package com.frikasoft.eduplus_univ.contract.finance;

import com.frikasoft.eduplus_univ.contract.IController;

public interface IFinancePost extends IController {

    void  savePaiementEtudiant(String descritpion, Integer fkAnneeAcademique,Integer fkEtudiant, Integer
            fkMotifPaiement, String mois, Double montant,String observation);
    void  saveFichePaie(String description, Integer fkAgent, String mois, Double montant, Integer fkMotifPaiement, String observation);




}
