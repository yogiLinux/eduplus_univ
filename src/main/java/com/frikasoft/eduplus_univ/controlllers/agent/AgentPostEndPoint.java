package com.frikasoft.eduplus_univ.controlllers.agent;

import com.frikasoft.eduplus_univ.entities.http.HttpDataResponse;
import com.frikasoft.eduplus_univ.service.agent.AgentServicePost;
import com.frikasoft.eduplus_univ.service.configuration.ConfigurationServicePost;
import com.frikasoft.eduplus_univ.settings.AppConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@CrossOrigin(origins = AppConst.CROS)
@RestController
@RequestMapping("/eduplusConfigPost")
public class AgentPostEndPoint {

    @Autowired
    private AgentServicePost agentServicePost;

    private HttpDataResponse dataResponse;
    @PostMapping("/addAgent")
    public HttpDataResponse addAgent(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String nom = requestParam.get("nom");
            String postnom = requestParam.get("postnom");
            String prenom = requestParam.get("prenom");
            String numeroTelephone = requestParam.get("telephone");
            Integer fkTypeAgent = Integer.valueOf(requestParam.get("fkTypeAgent"));
            String fonction = requestParam.get("fonction");
            String lieuNaissance =requestParam.get("lieuNaissance");
            Date dateNaissance = Date.valueOf(requestParam.get("dateNaissance"));
            String adresse = requestParam.get("adresse");
            String photoAgent = requestParam.get("photo");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                agentServicePost.saveAgent(nom, postnom, prenom, numeroTelephone, fonction, fkTypeAgent, lieuNaissance,
                        dateNaissance, adresse, photoAgent, idForUpdate );
                dataResponse.setError(agentServicePost.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

}
