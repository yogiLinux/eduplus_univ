package com.frikasoft.eduplus_univ.service.finance;

import com.frikasoft.eduplus_univ.contract.finance.IFinancePost;
import com.frikasoft.eduplus_univ.entities.db.Agent;
import com.frikasoft.eduplus_univ.entities.http.ErrorResponse;
import com.frikasoft.eduplus_univ.repository.finance.FichePaieRepository;
import com.frikasoft.eduplus_univ.repository.finance.PaiementEtudiantRepository;
import com.frikasoft.eduplus_univ.settings.AppConst;
import com.frikasoft.eduplus_univ.settings.AppUtilities;
import com.frikasoft.eduplus_univ.settings.DataValueException;
import org.springframework.beans.factory.annotation.Autowired;

public class PaiementServicePost implements IFinancePost {

    private ErrorResponse error = null;

    @Autowired
    private FichePaieRepository fichePaieRepository;
    @Autowired
    private PaiementEtudiantRepository paiementEtudiantRepository;
    @Override
    public ErrorResponse getErroResponse() {
        if(error==null)
            error = new ErrorResponse();
        return error ;
    }

    @Override
    public void savePaiementEtudiant(String descritpion, Integer fkAnneeAcademique, Integer fkEtudiant, Integer fkMotifPaiement, String mois, Double montant, String observation) {
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(descritpion, "Veuillez renseigner la description du paiement");
            AppUtilities.controlValue(fkAnneeAcademique, "L'année académique n'est pas renseignée");
            AppUtilities.controlValue(fkEtudiant, "Veuillez renseigner l'étudiant ou etudiante qui effectue le paiement");
            AppUtilities.controlValue(fkMotifPaiement, "Veuillez renseigner le motif du paiement");
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

    @Override
    public void saveFichePaie(String description, Integer fkAgent, String mois, Double montant, Integer fkMotifPaiement, String observation) {

    }
}
