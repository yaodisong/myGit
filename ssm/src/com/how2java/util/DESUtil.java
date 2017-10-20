package com.how2java.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * DES加密工具类
 * @author Administrator
 *
 */
public class DESUtil {

	private static Key key;
	private static String KEY_STR = "ty";
	
	static {
		try {
			// 初始化key
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			generator.init(new SecureRandom(KEY_STR.getBytes()));
			key = generator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 加密
	 * @param str
	 * @return
	 */
	public static String getEncryptStr(String str){
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 解密
	 * @param str
	 * @return
	 */
	public static String getDecryStr(String str){
		BASE64Decoder base64de = new BASE64Decoder();
		try {
			byte[] strBytes = base64de.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
