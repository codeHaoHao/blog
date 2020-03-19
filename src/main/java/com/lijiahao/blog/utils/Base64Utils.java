package com.lijiahao.blog.utils;

import java.util.Base64;

public class Base64Utils {
	public static String encrypt(String value) {
		byte[] bytes = value.getBytes();
        //Base64 加密
        String encoded = Base64.getEncoder().encodeToString(bytes);
        return encoded;
	}
	
	public static String decrypt(String value) {
		//Base64 解密
        byte[] decoded = Base64.getDecoder().decode(value);
 
        String decodeStr = new String(decoded);
        return decodeStr;
	}
}
