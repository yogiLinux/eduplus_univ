package com.frikasoft.eduplus_univ.controlllers.configuration;
import com.frikasoft.eduplus_univ.entities.http.HttpDataResponse;
import com.frikasoft.eduplus_univ.service.configuration.ConfigurationServiceGet;
import com.frikasoft.eduplus_univ.settings.AppConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = AppConst.CROS)
@RestController
@RequestMapping("/eduplusConfigGet")
public class ConfigurationGetEndPoint {

    @Autowired
    private ConfigurationServiceGet configurationServiceGet;
    private HttpDataResponse dataResponse;

    @GetMapping("/getAnneeAcademique/{id}")
    public HttpDataResponse getAnneeAcademique(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getAnneeAcademique(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }


    @GetMapping("/getAnneeAcademiqueList")
    public HttpDataResponse getListAnneeAcademique(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getAnneeAcademiqueAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }


    @GetMapping("/getAuditoire/{id}")
    public HttpDataResponse getAuditoire(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getAuditoire(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getAuditoireList")
    public HttpDataResponse getListAuditoire(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getAuditoireAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }

    @GetMapping("/getCours/{id}")
    public HttpDataResponse getCours(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getCours(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getCoursList")
    public HttpDataResponse getListCours(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getCoursAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }



    @GetMapping("/getDepartement/{id}")
    public HttpDataResponse getDepartement(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getDepartement(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getDepartementList")
    public HttpDataResponse getListDepartement(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getDepartementall());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }


    @GetMapping("/getEtablissement/{id}")
    public HttpDataResponse getEtablissement(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getEtablissement(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getEtablissementList")
    public HttpDataResponse getListEtablissement(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getEtablissementAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }


    @GetMapping("/getFaculte/{id}")
    public HttpDataResponse getFaculte(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getFaculte(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getFaculteList")
    public HttpDataResponse getListFaculte(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getFaculteAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }


    @GetMapping("/getMotifPaiement/{id}")
    public HttpDataResponse getMotifPaiement(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getMotifPaiement(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getMotifPaiementList")
    public HttpDataResponse getListMotifPaiement(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getMotifPaiementAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }


    @GetMapping("/getProvince/{id}")
    public HttpDataResponse getProvince(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getProvince(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getProvinceList")
    public HttpDataResponse getListProvince(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getProvinceAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }


    @GetMapping("/getVacation/{id}")
    public HttpDataResponse getVacation(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getVacation(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getVacationList")
    public HttpDataResponse getListVacation(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getVacationAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }

    @GetMapping("/getCategorieAgent/{id}")
    public HttpDataResponse getCategorieagent(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getCategorie(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getCategorieAgentAll")
    public HttpDataResponse getCategorieAll(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getCategorieAgentAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }

    @GetMapping("/getVille/{id}")
    public HttpDataResponse getVille(@PathVariable Integer id){
        dataResponse = new HttpDataResponse();
        try{
            dataResponse.setResponse(configurationServiceGet.getVille(id));
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch (Exception e){
            e.printStackTrace();
        }
        return  dataResponse;
    }

    @GetMapping("/getVilleList")
    public HttpDataResponse getListVille(){
        dataResponse = new HttpDataResponse();
        try {
            dataResponse.setResponse(configurationServiceGet.getVilleAll());
            dataResponse.setError(configurationServiceGet.getErroResponse());
        }catch(Exception e) {
            e.printStackTrace();
        }
        return dataResponse;
    }




}
