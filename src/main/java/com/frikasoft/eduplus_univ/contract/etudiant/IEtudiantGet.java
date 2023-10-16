package com.frikasoft.eduplus_univ.contract.etudiant;

import com.frikasoft.eduplus_univ.contract.IController;
import com.frikasoft.eduplus_univ.entities.db.Etudiant;

import java.util.List;

public interface IEtudiantGet extends IController {
    Etudiant getEtudiantById(Integer id);
    List<Etudiant> getEtudiantListByName(String name);
    List<Etudiant> getEtudiantByAnneeAcademique(String anneeAcademique);
    List<Etudiant> getEtudiantByanneeAndVacation(String anneeAcademique, String vacation);
    List<Etudiant> getEtudiantByVacation(String vacation);

}
