package com.company.springbootsell.utils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Random;

public class KeyUtil {
    public static synchronized String genUniqueKey(){
       Random random= new Random();
     Integer number= random.nextInt(900000)+100000;
     return System.currentTimeMillis()+String.valueOf(number);

    }

}
