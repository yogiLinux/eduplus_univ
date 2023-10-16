package com.frikasoft.eduplus_univ.repository.agent;

import com.frikasoft.eduplus_univ.entities.db.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AgentRepository extends JpaRepository<Agent, Integer> {

   /*** @Query("select new com.frikasoft.fiscplusMairie.entities.adapter.PersonneAdresseAdapter" +
            "(p.id, p.nom, p.postnom, p.prenom, a.quartier, a.avenue)" +
            "from Personne p  inner join Adresse a on p.adresse=a.id where nom like:keyword or postnom like:keyword or prenom like:keyword")
    public List<PersonneAdresseAdapter> getPersonneAdress(@Param("keyword")String keyword);**/

   @Query("from Agent where nom like:keyword or postnom like:keyword or prenom like:keyword and status = 1")
   public List<Agent> researchAgentByName(@Param("keyword")String keyword);


}
