package com.jhlishero.code.generator.core.freemarker;

import java.io.File;
import java.io.IOException;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

public class FreeMarkerFactory {
	
	private static Configuration cfg;
	
	private FreeMarkerFactory() {
	}
	
	public static Configuration newInstance(String directoryForTemplateLoading) {
		if (cfg != null) {
			return cfg;
		}
		try {
			cfg = new Configuration(Configuration.VERSION_2_3_23);
			cfg.setDirectoryForTemplateLoading(new File(directoryForTemplateLoading));
			cfg.setDefaultEncoding("UTF-8"); //模板文件的编码
			//cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cfg;
	}
}
