/*package com.java.template;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Path {
	public String getPath() throws UnsupportedEncodingException {
		String path = this.getClass().getClassLoader().getResource("")
				.getPath();
		String fullPath = URLDecoder.decode(path, "UTF-8");
		String pathArr[] = fullPath.split("/WEB-INF/classes/");
		fullPath = pathArr[0];
		String reponsePath = "";
		reponsePath = new File(fullPath).getPath() + File.separatorChar;
		return reponsePath;
	}
}
*/