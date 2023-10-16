package com.frikasoft.eduplus_univ.controlllers.configuration;


import com.frikasoft.eduplus_univ.entities.db.Anneeacademique;
import com.frikasoft.eduplus_univ.entities.http.HttpDataResponse;
import com.frikasoft.eduplus_univ.service.configuration.ConfigurationServicePost;
import com.frikasoft.eduplus_univ.settings.AppConst;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@CrossOrigin(origins = AppConst.CROS)
@RestController
@RequestMapping("/eduplusConfigPost")
public class ConfigurationPostEndPoint {
    @Autowired
    private ConfigurationServicePost configurationService;

    private HttpDataResponse dataResponse;
    @PostMapping("/addAnneeAcademique")
    public HttpDataResponse addAnneeAcademique(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description = requestParam.get("description");
            Date debut = Date.valueOf(requestParam.get("debut"));
            Date fin = Date.valueOf(requestParam.get("fin"));
            try {
               idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
               if(idForUpdate==null){
                   idForUpdate = 0;
               }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveAnneeAcademique(description,  debut,  fin, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @PostMapping("/addAuditoire")
    public HttpDataResponse addAuditoire(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description = requestParam.get("description");
            Integer fkAnneeAcademique = Integer.valueOf(requestParam.get("fkAnneeAcademique"));
            Integer fkDepartement = Integer.valueOf("fkDepartement");

            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveAuditoire(description,  fkAnneeAcademique,  fkDepartement, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @PostMapping("/addCours")
    public HttpDataResponse addCours(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description = requestParam.get("description");
            String commentaire = requestParam.get("commentaire");
            if(commentaire==null)
                commentaire="";
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveCours(description,  commentaire,  idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }


    @PostMapping("/addDepartement")
    public HttpDataResponse addDepartement(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description = requestParam.get("description");
            Integer fkFaculte = Integer.valueOf(requestParam.get("fkFaculte"));
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveDapartement(description,  fkFaculte,  idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }


    @PostMapping("/addEtablissement")
    public HttpDataResponse addEtablissement(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String adresse= requestParam.get("adresse");
            Integer fkVille = Integer.valueOf(requestParam.get("ville"));
            String logo = requestParam.get("logo");
            if(logo==null)
                logo = "";
            String description = requestParam.get("description");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveEtablissement(adresse,  fkVille, logo, description, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }


    @PostMapping("/addFaculte")
    public HttpDataResponse addFaculte(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description= requestParam.get("description");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveFaculte( description, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @PostMapping("/addMotifPaiment")
    public HttpDataResponse addMotifPaiement(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description= requestParam.get("description");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveMotifPaiement( description, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }


    @PostMapping("/addProvince")
    public HttpDataResponse addProvince(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description= requestParam.get("description");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveProvince( description, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @PostMapping("/addUser")
    public HttpDataResponse addUser(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String userName = requestParam.get("userName");
            String password = requestParam.get("password");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveUser( userName, password, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }


    @PostMapping("/addVacation")
    public HttpDataResponse addVacation(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description = requestParam.get("description");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveVacation( description, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @PostMapping("/addVille")
    public HttpDataResponse addVille(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description = requestParam.get("description");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveVille( description, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @PostMapping("/addCategorieAgent")
    public HttpDataResponse addCategorieAgent(@RequestParam Map<String, String> requestParam){
        dataResponse = new HttpDataResponse();
        Integer idForUpdate = 0;
        try {
            String description = requestParam.get("description");
            try {
                idForUpdate = Integer.valueOf(requestParam.get("idForUpdate"));
                if(idForUpdate==null){
                    idForUpdate = 0;
                }
            }catch (Exception e){
                System.out.println("***** Il y a aucune id Pour effecteur la mise à jour ***** : ");
            }finally{
                configurationService.saveCategorieAgent( description, idForUpdate );
                dataResponse.setError(configurationService.getErroResponse());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }



}
