package com.express.util;

public class SystemConfig{
	
	private static String upload_root_path = "D:/apache-tomcat-7.0.54/webapps/upload";						//文件上传根路径

	public static String getUpload_root_path() {
		return upload_root_path;
	}

}
