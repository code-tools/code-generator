package com.jhlishero.code.generator.util;

import java.io.File;
import java.io.IOException;
import java.util.StringTokenizer;

public abstract class FileUtils {

	/**
	 * 检查目录是否存在
	 * @author hailiang.jiang
	 * @date 2015年4月1日 上午11:29:54
	 * @methodName com.jhlishero.code.generator.util.FileUtils.checkDirIsExisted
	 * @param dirPath
	 * @return
	 */
	public static boolean checkDirIsExisted(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}
	
	/**
	 * 创建新的目录
	 * @author hailiang.jiang
	 * @date 2015年4月1日 下午12:37:58
	 * @methodName com.jhlishero.code.generator.util.FileUtils.createDir
	 * @param baseDir
	 * @param dirPath
	 */
	public static String createDir(String baseDir, String dirPath) {
		if (!checkDirIsExisted(baseDir)) {
			throw new IllegalArgumentException("路径baseDir=" + baseDir + "不存在");
		}
		
		StringTokenizer st = new StringTokenizer(dirPath, File.separator);
		
		StringBuilder pathSb = new StringBuilder();
		pathSb.append(baseDir + (File.separatorChar == baseDir.charAt(baseDir.length() - 1) ? "" : File.separator));
		while (st.hasMoreTokens()) {
			pathSb.append(st.nextToken());
			File file = new File(pathSb.toString());
			if (!file.exists()) {
				file.mkdir();
			}
			pathSb.append(File.separator);
		}
		return pathSb.toString();
	}
	
	public static void deleteFile(String fileFullName) {
		new File(fileFullName).delete();
	}
	
	public static void createFile(String fileFullName) {
		if (checkDirIsExisted(fileFullName)) {
			deleteFile(fileFullName);
		}
		try {
			new File(fileFullName).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
