package com.frikasoft.eduplus_univ.contract.finance;

import com.frikasoft.eduplus_univ.contract.IController;

import java.math.BigDecimal;

public interface IFinancePost extends IController {

    void  savePaiementEtudiant(String descritpion, Integer fkAnneeAcademique, Integer fkEtudiant, Integer fkMotifPaiement, String mois, BigDecimal montant, String observation,
                               Integer idForUpdate);
    void  saveFichePaie(String description, Integer fkAgent, String mois, Double montant, Integer fkMotifPaiement, String observation);




}
