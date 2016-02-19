package com.jhlishero.code.generator.core;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.google.common.base.CaseFormat;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.jhlishero.code.generator.database.TableOptService;

public class CodeGeneratorFactoryTest {

	@Test
	public void testGenerate() {
		try {
			CodeGeneratorFactory.generate();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @author hailiang.jiang
	 * @date 2016年2月19日 下午2:22:08
	 * 生成的代码样式如下：
	 */
//	/**  **/
//	private java.lang.Long id;
//	/** 关联表最大id **/
//	private java.lang.Long maxId;
//	/** 关联表最小id **/
//	private java.lang.Long minId;
//	/** 关联类型 **/
//	private java.lang.String type;
//	/** 创建时间 **/
//	private java.util.Date createTime;
//
//
//	@Id
//	@Column(name="ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	public java.lang.Long getId() {
//		return this.id;
//	}
//
//	public void setId(java.lang.Long id) {
//		this.id = id;
//	}
//
//	@Column(name="MAX_ID")
//	public java.lang.Long getMaxId() {
//		return this.maxId;
//	}
//
//	public void setMaxId(java.lang.Long maxId) {
//		this.maxId = maxId;
//	}
//
//	@Column(name="MIN_ID")
//	public java.lang.Long getMinId() {
//		return this.minId;
//	}
//
//	public void setMinId(java.lang.Long minId) {
//		this.minId = minId;
//	}
//
//	@Column(name="TYPE")
//	public java.lang.String getType() {
//		return this.type;
//	}
//
//	public void setType(java.lang.String type) {
//		this.type = type;
//	}
//
//	@Column(name="CREATE_TIME")
//	public java.util.Date getCreateTime() {
//		return this.createTime;
//	}
//
//	public void setCreateTime(java.util.Date createTime) {
//		this.createTime = createTime;
//	}

	@Test
	public void testGenerateJavaCode() {
		try {
			TableOptService.generateJavaCode("oms_tmall_test", "t_sys_increment_assistant");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test() throws IOException {
		File file = new File("c:/test/test.txt");
		List<String> lines = Files.readLines(file, Charsets.UTF_8);
		
		StringBuilder columnSb = new StringBuilder();
		for (String line : lines) {
			Iterable<String> iter = Splitter.on(",").trimResults().omitEmptyStrings().split(line);
			Iterator<String> it = iter.iterator();
			while (it.hasNext()) {
				String result = it.next();
				
				Iterable<String> resultIterable = Splitter.on(".").trimResults().omitEmptyStrings().split(result);
				Iterator<String> resultIt = resultIterable.iterator();
				
				String formatStr = "";
				while (resultIt.hasNext()) {
					formatStr = resultIt.next();
				}
				if (!Strings.isNullOrEmpty(formatStr)) {
					columnSb.append(result).append(" AS ");
					columnSb.append(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, formatStr));
					columnSb.append(", ");
//					System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, formatStr))); // returns "constantName"
				}
			}
			columnSb.append(System.getProperty("line.separator"));
        }
		
		System.out.println(columnSb.toString());
	}
	
}
