package com.jhlishero.code.generator.cfg.comment;

/**
 * 公共注释
 * @author hailiang.jiang
 * @date 2015年4月1日 上午9:54:48
 */
public class BaseComment {
	/** 作者 **/
	protected String author;
	/** 代码日期 **/
	private String date;
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
}
