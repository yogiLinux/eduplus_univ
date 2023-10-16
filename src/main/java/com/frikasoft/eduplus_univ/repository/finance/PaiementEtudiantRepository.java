package com.frikasoft.eduplus_univ.repository.finance;

import com.frikasoft.eduplus_univ.entities.adapter.PaiementEtudiantAdapter;
import com.frikasoft.eduplus_univ.entities.db.PaiementEtudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface PaiementEtudiantRepository extends JpaRepository<PaiementEtudiant, Integer> {


    @Query("select new com.frikasoft.eduplus_univ.entities.adapter.PaiementEtudiantAdapter" +
            "(e.nom, e.post_nom, e.prenom, f.description, au.description, p.montant,  m.description, p.date_paiement, p.observation)" +
            "from Etudiant e  inner join PaiementEtudiant p on p.fk_etudiant=e.id " +
            "inner join where nom like:keyword or postnom like:keyword or prenom like:keyword")
    public List<PaiementEtudiantAdapter> getPaieEtudiantByAnneeAcademique(@Param("keyword")String keyword);

    String nomEtudiant;
    String postnom;
    String prenom;
    String faculte;
    String auditoire;
    Double montant;
    String motif;
    Date datePaiement;
    String Observation;
}
