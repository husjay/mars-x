package com.mars.x.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sj.hu on 2019/4/1.
 */
public class TimeUtils {

    public static Date addDays(Date date,int days){
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.set(Calendar.HOUR_OF_DAY,0);
        instance.set(Calendar.MINUTE,0);
        instance.set(Calendar.SECOND,0);
        instance.set(Calendar.MILLISECOND,0);
        instance.add(Calendar.DAY_OF_MONTH,days);
        return instance.getTime();
    }

}
