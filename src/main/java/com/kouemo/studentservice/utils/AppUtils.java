package com.kouemo.studentservice.utils;

import org.hibernate.ObjectNotFoundException;

import java.util.Optional;

public class AppUtils {

    public static Long converToLong(String number){
        try{
            return Long.valueOf(number);
        }catch (NumberFormatException numberFormatException){
            throw new ObjectNotFoundException(Optional.ofNullable(number),"convert");
        }
    }

    public static Integer convertToInteger(String number){
        try{
            return Integer.valueOf(number);
        }catch (NumberFormatException numberFormatException){
            throw new ObjectNotFoundException(Optional.ofNullable(number),"convert");
        }
    }
}
