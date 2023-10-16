package com.frikasoft.eduplus_univ.service.agent;

import com.frikasoft.eduplus_univ.contract.agent.IAgentPost;
import com.frikasoft.eduplus_univ.entities.db.Agent;
import com.frikasoft.eduplus_univ.entities.db.Anneeacademique;
import com.frikasoft.eduplus_univ.entities.http.ErrorResponse;
import com.frikasoft.eduplus_univ.repository.agent.AgentRepository;
import com.frikasoft.eduplus_univ.settings.AppConst;
import com.frikasoft.eduplus_univ.settings.AppUtilities;
import com.frikasoft.eduplus_univ.settings.DataValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AgentServicePost implements IAgentPost {

    private ErrorResponse error = null;


    @Autowired
    private AgentRepository agentRepository;
    @Override
    public ErrorResponse getErroResponse() {
        if(error==null)
            error = new ErrorResponse();
        return error;
    }

    @Override
    public void saveAgent(String nom, String postnom, String prenom, String numeroTelephone, String fonction, Integer fkTypeAgent,
                          String lieuNaissance, Date dateNaissance, String adresse, String photoAgent, Integer idForUpdate) {

        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(nom, "Veuillez renseigner le nom de l'agent");
            AppUtilities.controlValue(postnom, "Veuillez renseigner le postnom de l'agent");
            AppUtilities.controlValue(prenom, "Veuillez renseigner le prenom de l'agent");
            AppUtilities.controlValue(numeroTelephone, "Veuillez renseigner le numero téléphone  de l'agent");
            AppUtilities.controlValue(fkTypeAgent, "Veuillez renseigner le type");
            AppUtilities.controlValue(lieuNaissance, "Veuillez renseigner le lieu de naissance");
            AppUtilities.controlValue(dateNaissance, "Veuillez renseigner la date de naissance de l'agent");
            AppUtilities.controlValue(adresse, "Veuillez renseigner l'adresse de l'agent");
            AppUtilities.controlValue(photoAgent, "Veuillez charger la photo de l'agent");

            var agent = new Agent();
            agent.setNom(nom);
            agent.setPostNom(postnom);
            agent.setPrenom(prenom);
            agent.setNumeroTelephone(numeroTelephone);
            agent.setTypeAgent(fkTypeAgent);
            agent.setLieuNaissance(lieuNaissance);
            agent.setDateNaissance(dateNaissance);
            agent.setAdresseAgent(adresse);
            agent.setPhoto(photoAgent);
            agent.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                agent = agentRepository.findById(idForUpdate).orElse(agent);
                agent.setNom(nom);
                agent.setPostNom(postnom);
                agent.setPrenom(prenom);
                agent.setNumeroTelephone(numeroTelephone);
                agent.setTypeAgent(fkTypeAgent);
                agent.setLieuNaissance(lieuNaissance);
                agent.setDateNaissance(dateNaissance);
                agent.setAdresseAgent(adresse);
                agent.setPhoto(photoAgent);
                agent.setStatus(true);
            }
            var save =  agentRepository.save(agent);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Agent:" +agent.getNom()+" enregistrée avec succès");
            } else {
                throw new DataValueException(AppConst.SAVING_FAILED);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.SAVING_ERROR);
        }

    }
}
