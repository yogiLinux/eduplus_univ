package com.frikasoft.eduplus_univ.service.finance;

import com.frikasoft.eduplus_univ.contract.finance.IFinancePost;
import com.frikasoft.eduplus_univ.entities.db.Agent;
import com.frikasoft.eduplus_univ.entities.db.Fichepaie;
import com.frikasoft.eduplus_univ.entities.db.PaiementEtudiant;
import com.frikasoft.eduplus_univ.entities.http.ErrorResponse;
import com.frikasoft.eduplus_univ.repository.finance.FichePaieRepository;
import com.frikasoft.eduplus_univ.repository.finance.PaiementEtudiantRepository;
import com.frikasoft.eduplus_univ.settings.AppConst;
import com.frikasoft.eduplus_univ.settings.AppUtilities;
import com.frikasoft.eduplus_univ.settings.DataValueException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Date;

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
    public void savePaiementEtudiant(String descritpion, Integer fkAnneeAcademique, Integer fkEtudiant, Integer fkMotifPaiement, String mois, BigDecimal montant, String observation,
                                     Integer idForUpdate) {
        long millis = System.currentTimeMillis();
        error = new ErrorResponse();
        try {
            AppUtilities.controlValue(descritpion, "Veuillez renseigner la description du paiement");
            AppUtilities.controlValue(fkAnneeAcademique, "L'année académique n'est pas renseignée");
            AppUtilities.controlValue(fkEtudiant, "Veuillez renseigner l'étudiant ou etudiante qui effectue le paiement");
            AppUtilities.controlValue(fkMotifPaiement, "Veuillez renseigner le motif du paiement");
            AppUtilities.controlValue(montant, "Veuillez renseigner le montant payé");
            AppUtilities.controlValue(observation, "la case observation est vide");

            var paiementEtudiant = new PaiementEtudiant();
            paiementEtudiant.setDescription(descritpion);
            paiementEtudiant.setFkAnneeScolaire(fkAnneeAcademique);
            paiementEtudiant.setFkEtudiant(fkEtudiant);
            paiementEtudiant.setFkMotifPaiement(fkMotifPaiement);
            if(mois == null)
                 mois = "--";
            paiementEtudiant.setMois(mois);
            paiementEtudiant.setMontant(montant);
            paiementEtudiant.setObservation(observation);
            paiementEtudiant.setDatePaiement(new java.sql.Date(millis));
            paiementEtudiant.setStatus(true);
            if(idForUpdate!=null && idForUpdate>0) {
                paiementEtudiant = paiementEtudiantRepository.findById(idForUpdate).orElse(paiementEtudiant);
                paiementEtudiant.setDescription(descritpion);
                paiementEtudiant.setFkAnneeScolaire(fkAnneeAcademique);
                paiementEtudiant.setFkEtudiant(fkEtudiant);
                paiementEtudiant.setFkMotifPaiement(fkMotifPaiement);
                if(mois == null)
                    mois = "--";
                paiementEtudiant.setMois(mois);
                paiementEtudiant.setMontant(montant);
                paiementEtudiant.setObservation(observation);
                paiementEtudiant.setDatePaiement(new Date(millis));
                paiementEtudiant.setStatus(true);
            }
            var save =  paiementEtudiantRepository.save(paiementEtudiant);
            if (save != null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Paiement effectué avec succès");
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


    @Override
    public void saveFichePaie(String description, Integer fkAgent, String mois, Double montant, Integer fkMotifPaiement, String observation) {

    }
}
