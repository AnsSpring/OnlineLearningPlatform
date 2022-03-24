package com.util;

public class Common {

	//////过滤掉字符串里面的空格
	public static String filterSpace(String str){
		
		//去掉字符串里面的所有空格
		str = str.replace(" ", "");
		 
		return str;
	}

}
