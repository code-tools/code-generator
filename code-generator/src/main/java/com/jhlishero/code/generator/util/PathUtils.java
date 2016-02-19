package com.jhlishero.code.generator.util;

import java.io.File;

/**
 * @author hailiang.jiang
 * @date 2015年4月1日 下午1:12:32
 */
public class PathUtils {

	/**
	 * 获取项目工程根目录
	 * @author hailiang.jiang
	 * @date 2015年4月1日 下午1:12:08
	 * @return
	 */
	public static String getProject() {
		String userDir = System.getProperty("user.dir");
		return userDir;
	}
	
	/**
	 * 获取Maven工程源文件所在根目录
	 * @author hailiang.jiang
	 * @date 2015年4月1日 下午1:12:24
	 * @return
	 */
	public static String getMavenProjectSourceCodeRootDir() {
		return getProject() + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator;
	}
}
