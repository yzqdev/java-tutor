package com.yzq.tutor.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created time 2021/3/2 10:21
 *
 * @author Yangzhengqian
 */
public class FindItem {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String[] fieldsToInclude = {"id", "name", "location"};
        boolean a = Arrays.asList(fieldsToInclude).contains("id");
        System.out.println(a);

        String string = "004-034556";
        String[] parts = string.split("-");
        for (String s : parts) {
            System.out.println(s);
        }
        String yourString = "abcdef";
        byte[] bytesOfMessage = yourString.getBytes(StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        System.out.println(md);
        //if ( ArrayUtils.contains( fieldsToInclude, "id" ) ) {
        //    System.out.println("yes");  // Do some stuff.
        //}
    }
}
