package com.frikasoft.eduplus_univ.controlllers.agent;

import com.frikasoft.eduplus_univ.entities.http.HttpDataResponse;
import com.frikasoft.eduplus_univ.service.agent.AgentServiceGet;
import com.frikasoft.eduplus_univ.service.configuration.ConfigurationServiceGet;
import com.frikasoft.eduplus_univ.settings.AppConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = AppConst.CROS)
@RestController
@RequestMapping("/eduplusAgentGet")
public class AgentGetEndPoint {


    @Autowired
    private AgentServiceGet agentServiceGet;
    private HttpDataResponse dataResponse;

    @GetMapping("/getAgent/{id}")
    public HttpDataResponse getAgent(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(agentServiceGet.getAgentById(id));
            dataResponse.setError(agentServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }


    @GetMapping("/getAgenetList")
    public HttpDataResponse getListAgent(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(agentServiceGet.getListAgents());
            dataResponse.setError(agentServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }


}
