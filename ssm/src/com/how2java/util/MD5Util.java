package com.how2java.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author Administrator
 *
 */
public class MD5Util {
	
	private static String key = "ty";
	
	public static String byteArrToString(byte[] bytes, int length) {
       char[] chars = new char[length];
 
       for (int i = 0; i != chars.length; i++) {
           chars[i] = (char) (bytes[i] & 0xff);
       }
 
       return new String(chars);
    }
	
	public static String byteArrToString(byte[] bytes) {
       return byteArrToString(bytes, bytes.length);
    }
	
	public static byte[] toByteArray(String string) {
       byte[] bytes = new byte[string.length()];
       char[] chars = string.toCharArray();
 
       for (int i = 0; i != chars.length; i++) {
           bytes[i] = (byte) chars[i];
       }
 
       return bytes;
    }
	
	public static String getEncode(String input) {
       if (null == input || input.trim().equals("")) {
           return input;
       }
       byte[] newPass = new byte[] {};
       try {
           newPass = input.getBytes("UTF-8");
       } catch (UnsupportedEncodingException e) {
           newPass = toByteArray(input);
       }
 
       MessageDigest hash;
       try {
           hash = MessageDigest.getInstance("MD5");
       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
           throw new RuntimeException("not exsit md5 algorithm");
       }
       hash.update(newPass);
       byte[] cipherPass = hash.digest();
       try {
           input = new String(cipherPass, "UTF-8");
       } catch (UnsupportedEncodingException e) {
           input = byteArrToString(cipherPass);
       }
       return input;
    }

	public static String encode(String str){
		byte[] b = (key + str + key).getBytes();
		byte[] b1 = new byte[b.length];
		for(int i = 0; i < b.length; i++){
			byte temp = b[i];
			b1[i] = (temp == 255 ? 0 : ++temp);
		}
		return new String(b1);
	}
	
	public static String decode(String str){
		byte[] b = str.getBytes();
		byte[] b1 = new byte[b.length];
		byte bMax = (byte)255;
		for(int i = 0; i < b.length; i++){
			byte temp = b[i];
			b1[i] = (temp == 255 ? bMax : --temp);
		}
		return new String(b1);
	}
}
