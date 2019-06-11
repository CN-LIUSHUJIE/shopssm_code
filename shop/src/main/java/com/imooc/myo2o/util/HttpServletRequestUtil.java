package com.imooc.myo2o.util;

import javax.servlet.http.HttpServletRequest;

public class HttpServletRequestUtil {
    public static String getString(HttpServletRequest request,String name) {
        try {
            String result = request.getParameter(name);
            if (result != null) {
                result = result.trim();
            }
            if ("".equals(result))
                result = null;
            return result;
        } catch (Exception e) {
            return null;
        }


    }
    public static Boolean getBoolean(HttpServletRequest request, String name) {

        try {
            return Boolean.valueOf(request.getParameter(name));
        } catch (Exception e) {
            return false;
        }
    }
}
