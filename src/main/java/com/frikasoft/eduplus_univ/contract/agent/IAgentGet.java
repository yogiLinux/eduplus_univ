package com.frikasoft.eduplus_univ.contract.agent;

import com.frikasoft.eduplus_univ.contract.IController;
import com.frikasoft.eduplus_univ.entities.db.Agent;

import java.util.List;

public interface IAgentGet extends IController {
    Agent getAgentById(Integer id);
    List<Agent> findAgentByName(String name);
    List<Agent> getListAgents();


}
