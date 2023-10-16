package com.frikasoft.eduplus_univ.service.agent;

import com.frikasoft.eduplus_univ.contract.agent.IAgentGet;
import com.frikasoft.eduplus_univ.entities.db.Agent;
import com.frikasoft.eduplus_univ.entities.db.Anneeacademique;
import com.frikasoft.eduplus_univ.entities.http.ErrorResponse;
import com.frikasoft.eduplus_univ.repository.agent.AgentRepository;
import com.frikasoft.eduplus_univ.settings.AppConst;
import com.frikasoft.eduplus_univ.settings.AppUtilities;
import com.frikasoft.eduplus_univ.settings.DataValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceGet implements IAgentGet {

    private ErrorResponse error = null;

    @Autowired
    private AgentRepository agentRepository;
    @Override
    public ErrorResponse getErroResponse() {
        if(error==null)
            error = new ErrorResponse();
        return error;
    }

    @Override
    public Agent getAgentById(Integer id) {
        error = new ErrorResponse();
        Agent  agent = null;
        try {
            AppUtilities.controlValue(id, "Vueillez séléctionner l'agent");
            agent =  agentRepository.findById(id).orElse(null);
            if(agent!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici l'agent séléctionné :" + agent.getNom());
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return agent;
    }

    @Override
    public List<Agent>findAgentByName(String name) {
        error = new ErrorResponse();
        List<Agent> agents = null;
        try {
            agents =  agentRepository.researchAgentByName(name);
            if(agents!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la correspondance du mot clé recherché ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return agents;
    }

    @Override
    public List<Agent> getListAgents() {
        error = new ErrorResponse();
        List<Agent> agents = null;
        try {
            agents =  agentRepository.findAll();
            if(agents!=null) {
                error.setErrorCode(ErrorResponse.OK);
                error.setErrorDescription("Voici la liste des agents: ");
            }else {
                throw new DataValueException(AppConst.VALUE_NOT_FOUND);
            }
        }catch(DataValueException e){
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(e.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            error.setErrorCode(ErrorResponse.KO);
            error.setErrorDescription(AppConst.GETTING_VALUE_ERROR);
        }
        return agents;
    }
}
