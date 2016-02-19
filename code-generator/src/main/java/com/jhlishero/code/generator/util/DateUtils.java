package com.jhlishero.code.generator.util;

import java.util.Date;

public class DateUtils {

	/**
	 * 获取注释格式日期
	 * @author hailiang.jiang
	 * @date 2015年4月1日 下午2:39:51
	 * @param date
	 * @return
	 */
	public static String getCommentDate(Date date) {
		StringBuffer dateSb = new StringBuffer();
		dateSb.append(String.format("%tY年", date));
		dateSb.append(String.format("%tm月", date));
		dateSb.append(String.format("%td日", date));
		dateSb.append(String.format(" %tp", date));
		dateSb.append(String.format("%tk:", date));
		dateSb.append(String.format("%tM:", date));
		dateSb.append(String.format("%tS", date));
		return dateSb.toString();
	}
	
}
