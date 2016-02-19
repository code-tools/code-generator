package com.jhlishero.code.generator.core;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

import com.jhlishero.code.generator.constant.Constant;
import com.jhlishero.code.generator.util.ClassUtils;
import com.jhlishero.code.generator.util.PropertiesLoaderUtils;

import freemarker.template.Configuration;

public class FreeMarkerFactory {
	
	public static final String PROPS_CFG = "cfg.properties";
	public static final String PROPS_CLAZZ = "clazz.properties";
	public static Properties CFG_PROPS = null;
	public static Properties CLAZZ_PROPS = null;
	static {
		try {
			CFG_PROPS = PropertiesLoaderUtils.loadAllProperties(PROPS_CFG);
			CLAZZ_PROPS = PropertiesLoaderUtils.loadAllProperties(PROPS_CLAZZ);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Configuration FREEMARKER_CFG = null;

	private FreeMarkerFactory() {
		
	}
	
	@SuppressWarnings("deprecation")
	public static Configuration newInstance() throws IOException {
		if (FREEMARKER_CFG != null) {
			return FREEMARKER_CFG;
		}
		
		URL url = ClassUtils.getDefaultClassLoader().getResource(CFG_PROPS.getProperty(Constant.PROPS_CFG_TEMPLATE_PATH));
		// 创建Freemarker配置实例
		FREEMARKER_CFG = new Configuration();
		try {
			FREEMARKER_CFG.setDirectoryForTemplateLoading(new File(url.toURI()));
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		return FREEMARKER_CFG;
	}
	
}
