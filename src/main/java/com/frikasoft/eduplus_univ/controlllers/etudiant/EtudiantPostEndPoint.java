package com.frikasoft.eduplus_univ.controlllers.etudiant;

import com.frikasoft.eduplus_univ.entities.http.HttpDataResponse;
import com.frikasoft.eduplus_univ.service.etudiant.EtudiantServicePost;
import com.frikasoft.eduplus_univ.settings.AppConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@CrossOrigin(origins = AppConst.CROS)
@RestController
@RequestMapping("/eduplusEtudiantPost")
public class EtudiantPostEndPoint {

    @Autowired
    private EtudiantServicePost etudiantServicePost;

    private HttpDataResponse dataResponse;

    @PostMapping("/addEtudiant")
    public HttpDataResponse addAgent(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String adresse = requestParam.get("adresse");
            Date dateNaissance = Date.valueOf(requestParam.get("dateNaissance"));
            String lieuNaissance = requestParam.get("lieuNaissance");
            String nom = requestParam.get("nom");
            String nomTuteur = requestParam.get("nomTuteur");
            String telephone = requestParam.get("telephone");
            String photo = requestParam.get("photo");
            String postnom = requestParam.get("postnom");
            String prenom = requestParam.get("prenom");
            String sexe = requestParam.get("sexe");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                etudiantServicePost.saveEtudiant(adresse, dateNaissance, lieuNaissance, nom, nomTuteur, telephone,
                        photo, postnom, prenom, sexe, idForUpdate);
                dataResponse.setError(etudiantServicePost.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }
}
