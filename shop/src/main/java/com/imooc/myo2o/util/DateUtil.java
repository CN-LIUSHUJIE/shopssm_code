package com.imooc.myo2o.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LIUSHUJIE
 * @date 2019/6/6 16:19
 */
public class DateUtil {
    final static public String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将 时间类型转成 字符串的 yyyy-MM-dd HH:mm:ss 格式
     * @param date
     * @return
     */
    public static String dateFormat(Date date){
        try{
            SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
            //获取String类型的时间
            String dateStr = sdf.format(date);
            return dateStr;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 获取当前的时间 字符串的 yyyy-MM-dd HH:mm:ss 格式
     */
    public static  String getNowDatesStr(){
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        return createdate;
    }

    public static  Date getNowDate() throws ParseException {
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        Date nowDate = sdf.parse(createdate);//将formate型转化成Date数据类型
        return nowDate;
    }
    /**
     * 将字符串转为 date 类型 格式为 yyyy-MM-dd
     * @param day
     * @return
     * @throws ParseException
     */
    public static Date dateFormat(String day) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//定义一个formate
        Date date = simpleDateFormat.parse(day);//将formate型转化成Date数据类型
        return date;

    }

}
