package com.lijiahao.blog;

import com.lijiahao.blog.utils.Md5Utils;
import com.lijiahao.blog.utils.TimeUtils;

public class Test {
	public static void main(String[] args) {
		System.out.println(Md5Utils.encrypt("zhanchigaofei!", "fdstfdgeeggd"));
		System.out.println(TimeUtils.getTodayDate());
	}
}
