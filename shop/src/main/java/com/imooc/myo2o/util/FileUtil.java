package com.imooc.myo2o.util;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * @author LIUSHUJIE
 * @date 2019/6/11 10:04
 */
public class FileUtil {
    private  static  String seperator = System.getProperty("file.separator");
    //时间格式化
    private static  final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
//resources/images/item/shopcategory/2017060420315183203.png
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectdev/image/";
        } else {
            basePath = "/home/xiangzepro/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static  void deleteFile(String storePath){
        File file = new File(getImgBasePath()+storePath);
        if (file.exists()) {
            if (file.isDirectory()) {
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            file.delete();
        }
    }
}
