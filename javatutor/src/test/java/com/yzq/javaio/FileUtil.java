package com.yzq.javaio;


import java.io.*;

/**
 * @author yanni
 * @date time 2021/11/8 14:10
 * @modified By:
 */
public class FileUtil {
    public static InputStream getFileAsBufferSteam(String filename) {
        ClassLoader ret = Thread.currentThread().getContextClassLoader();
        if (ret != null) {
            return FileUtil.class.getClassLoader().getResourceAsStream(filename);
        }
        return null;

    }
    public static OutputStream setFileAsSteam(String filename){
        File file=new File("src/main/resources/"+filename);
        try {
            return new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }   public static InputStream getFileAsSteam(String filename){
        File file=new File("src/main/resources/"+filename);
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
