package com.frikasoft.eduplus_univ.controlllers.etudiant;


import com.frikasoft.eduplus_univ.entities.http.HttpDataResponse;
import com.frikasoft.eduplus_univ.service.etudiant.EtudiantServiceGet;
import com.frikasoft.eduplus_univ.settings.AppConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = AppConst.CROS)
@RestController
@RequestMapping("/eduplusEtudiantGet")
public class EtudiantGetEndPoint {
    @Autowired
    private EtudiantServiceGet etudiantServiceGet;

    private HttpDataResponse dataResponse;

    @GetMapping("/getEtutiant/{id}")
    public HttpDataResponse getEtudiant(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(etudiantServiceGet.getEtudiantById(id));
            dataResponse.setError(etudiantServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getEtutiantListByName/{name}")
    public HttpDataResponse getEtudiantListByName(@PathVariable String name){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(etudiantServiceGet.getEtudiantListByName(name));
            dataResponse.setError(etudiantServiceGet.getErroResponse());
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataResponse;
    }


    @GetMapping("/getEtutiantListByAnnneeAcademique/{anneeAcademique}")
    public HttpDataResponse getEtudiantByAnneeAcademique(@PathVariable String anneeAcademique){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(etudiantServiceGet.getEtudiantByAnneeAcademique(anneeAcademique));
            dataResponse.setError(etudiantServiceGet.getErroResponse());
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataResponse;
    }

    @GetMapping("/getEtutiantListByAnneeAndVacation/{anneeAcademique}, /{vacation}")
    public HttpDataResponse getEtudiantByanneeAndVacation(@PathVariable String anneeAcademique, @PathVariable String vacation){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(etudiantServiceGet.getEtudiantByanneeAndVacation(anneeAcademique, vacation));
            dataResponse.setError(etudiantServiceGet.getErroResponse());
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataResponse;
    }

    @GetMapping("/getEtutiantListByVacation/{vacation}")
    public HttpDataResponse getEtudiantByVacation(@PathVariable String vacation){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(etudiantServiceGet.getEtudiantByVacation(vacation));
            dataResponse.setError(etudiantServiceGet.getErroResponse());
        }catch(Exception e){
            e.printStackTrace();
        }
        return dataResponse;
    }


}
