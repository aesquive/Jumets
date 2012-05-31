/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.urbi.utils.valueobject;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author JuCMuro
 */
public class ProcessValueObject {
    public static String genericError="Generic_Error";
    private Map<String,Object> infoResult;
    private Map<String,String> addError;

    public ProcessValueObject(){
       this.addError=new HashMap<String, String>();
       this.infoResult=new HashMap<String, Object>();
    }



    public  Map<String, String> getAddError() {
        return addError;
    }

    public void setAddError(String errorKey, String errorDescription) {
        this.addError.put(errorKey, errorDescription);
    }

    public Map<String, Object> getInfoResult() {
        return infoResult;
    }

    public void setInfoResult(String infoKey, Object obj) {
        this.infoResult.put(infoKey, obj);
    }



    
    public boolean isError(){
        return addError.isEmpty();
    }

}
