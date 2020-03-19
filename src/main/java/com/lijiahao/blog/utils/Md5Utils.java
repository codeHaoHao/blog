package com.lijiahao.blog.utils;

import org.springframework.util.DigestUtils;

/**
 * 用户密码MD5加密工具
 * @author Frank Li
 *
 */
public class Md5Utils {
	public static String encrypt(String str,String salt) {
		String strWithsalt = str + salt;
		String md5 = DigestUtils.md5DigestAsHex(strWithsalt.getBytes());
		return md5;
	}
}
