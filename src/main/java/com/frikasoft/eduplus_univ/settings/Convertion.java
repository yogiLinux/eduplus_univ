package com.frikasoft.eduplus_univ.settings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Convertion {

    public static Date getEcheanceFromNow(Long nombreJour){
        Date echeance = null;
        LocalDate dateLocale = LocalDate.now().plusDays(nombreJour);
        echeance = (Date) Date.from(dateLocale.atStartOfDay(ZoneId.systemDefault()).toInstant());

        return echeance;
    }

    public static java.sql.Date stringToDate(String value) throws ParseException {
        java.sql.Date sqlDate = null;
        try {
            Date date = null;
            date = new SimpleDateFormat("yyyy-MM-dd").parse(value);
            sqlDate = new java.sql.Date(date.getTime());
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlDate;
    }
}
