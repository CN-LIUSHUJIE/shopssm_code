package com.imooc.myo2o.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LIUSHUJIE
 * @date 2019/6/6 16:19
 */
public class DateUtil {
    final  private String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将 时间类型转成 字符串的 yyyy-MM-dd HH:mm:ss 格式
     * @param date
     * @return
     */
    public String dateFormat(Date date){
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
    public String getNowDatesStr(){
        //我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //获取String类型的时间
        String createdate = sdf.format(date);
        return createdate;
    }
}
