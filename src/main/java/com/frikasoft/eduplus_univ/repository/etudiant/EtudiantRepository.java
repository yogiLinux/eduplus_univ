package com.frikasoft.eduplus_univ.repository.etudiant;

import com.frikasoft.eduplus_univ.entities.db.Agent;
import com.frikasoft.eduplus_univ.entities.db.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {


    /*** @Query("select new com.frikasoft.fiscplusMairie.entities.adapter.PersonneAdresseAdapter" +
     "(p.id, p.nom, p.postnom, p.prenom, a.quartier, a.avenue)" +
     "from Personne p  inner join Adresse a on p.adresse=a.id where nom like:keyword or postnom like:keyword or prenom like:keyword")
     public List<PersonneAdresseAdapter> getPersonneAdress(@Param("keyword")String keyword);**/

    @Query("from Etudiant where nom like:keyword or postnom like:keyword or prenom like:keyword and status = 1")
    public List<Etudiant> researchEtudiantByName(@Param("keyword")String keyword);

    @Query("from Etudiant e inner join Inscription  i  on e.id=i.fkEtudiant inner join Anneeacademique a on a.id = i.fkAnneeAcademique  where a.description like:keyword  and e.status = 1")
     public List<Etudiant> searchByAnneeAcademique(@Param("keyword")String keyword);


    @Query("from Etudiant e inner join Inscription  i  on e.id=i.fkEtudiant inner join Anneeacademique a on a.id = i.fkAnneeAcademique inner join " +
            "Vacation v on v.id = i.fkVacation where a.description like:keyword1  and v.description like:keyword2 and e.status = 1")
    public List<Etudiant> searchByAnneeAcademiqueAndVacation(@Param("keyword1")String keyword1, @Param("keyword2") String keyword2);

    @Query("from Etudiant e inner join Inscription  i  on e.id=i.fkEtudiant inner join Anneeacademique a on a.id = i.fkAnneeAcademique inner join " +
            "Vacation v on v.id = i.fkVacation where  v.description like:keyword and e.status = 1")
    public List<Etudiant> searchByVacation(@Param("keyword")String keyword);
}
