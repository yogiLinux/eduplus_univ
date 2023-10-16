package com.frikasoft.eduplus_univ.contract.agent;

import com.frikasoft.eduplus_univ.contract.IController;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public interface IAgentPost extends IController {

    void saveAgent(String nom, String postnom, String prenom, String numeroTelephone, String fonction, Integer fkTypeAgent,
                   String lieuNaissance, Date dateNaissance, String adresse, String photoAgent, Integer idForUpdate);
}
