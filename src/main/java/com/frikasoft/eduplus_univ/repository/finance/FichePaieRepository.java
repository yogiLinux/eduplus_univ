package com.frikasoft.eduplus_univ.repository.finance;

import com.frikasoft.eduplus_univ.entities.adapter.PaiementEtudiantAdapter;
import com.frikasoft.eduplus_univ.entities.db.Fichepaie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface FichePaieRepository extends JpaRepository<Fichepaie, Integer> {

    /*** @Query("select new com.frikasoft.fiscplusMairie.entities.adapter.PersonneAdresseAdapter" +
     "(p.id, p.nom, p.postnom, p.prenom, a.quartier, a.avenue)" +
     "from Personne p  inner join Adresse a on p.adresse=a.id where nom like:keyword or postnom like:keyword or prenom like:keyword")
     public List<PersonneAdresseAdapter> getPersonneAdress(@Param("keyword")String keyword);**/



}
