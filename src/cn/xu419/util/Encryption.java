package cn.xu419.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Encryption {
    private Encryption(){}

    public static String EncoderByMd5(String str){
        //确定计算方法
        MessageDigest md5= null;
        String result="";
        try {
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            result=base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }
    public static boolean checkMd5Password(String newPassword,String oldPassword) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        return EncoderByMd5(newPassword).equals(oldPassword);
    }

}
