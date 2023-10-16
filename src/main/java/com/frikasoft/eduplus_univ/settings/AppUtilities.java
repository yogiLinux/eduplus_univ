package com.frikasoft.eduplus_univ.settings;

import java.sql.Date;
import java.util.List;

public class AppUtilities {

    public AppUtilities(){
    }

    public static void  controlValue(List list, String message)throws DataValueException{
        if(list.isEmpty()|| list==null){
            throw new DataValueException(message);
        }
    }

    public static void controlValue(String s, String message)throws DataValueException{
        if(s.length()==0 || s==null){
            throw new DataValueException(message);
        }
    }

    public static void controlValue(Date date, String message) throws DataValueException{
        if(date == null ){
            throw new DataValueException(message);
        }
    }
    public static void controlValue(Integer i, String message) throws DataValueException{
        if(i == null){
            throw new DataValueException(message);
        }
    }
    public static void controlValue(Double d, String message)throws DataValueException{
        if(d==null){
            throw new DataValueException(message);
        }
    }

    public static void controlValue(byte[] b, String message)throws DataValueException{
        if(b.length == 0 || b == null){
            throw new DataValueException(message);
        }
    }

    public static void controlValue(Long l, String message)throws DataValueException{
        if(l == null ){
            throw new DataValueException(message);
        }
    }

    public static void controlValue(Boolean b, String message)throws DataValueException{
        if(b==null){
            throw new DataValueException(message);
        }

    }
    public static void controlValue(Object obj, String message)throws DataValueException{
        if(obj==null){
            throw new DataValueException(message);
        }

    }



}
