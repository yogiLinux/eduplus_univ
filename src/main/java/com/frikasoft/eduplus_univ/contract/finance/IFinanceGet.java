package com.frikasoft.eduplus_univ.contract.finance;

import com.frikasoft.eduplus_univ.contract.IController;
import com.frikasoft.eduplus_univ.entities.adapter.PaieAgentAdapter;
import com.frikasoft.eduplus_univ.entities.adapter.PaiementEtudiantAdapter;
import com.frikasoft.eduplus_univ.entities.db.Etudiant;

import java.util.List;

public interface IFinanceGet extends IController {

    List<PaiementEtudiantAdapter> getPaiementEtudiantByAnneeAcademique(String anneeAcademique);
    List<PaieAgentAdapter>getPaiementAgent(String annneeAcademique);




}
