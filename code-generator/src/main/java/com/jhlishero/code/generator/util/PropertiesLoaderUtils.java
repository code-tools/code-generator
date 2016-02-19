package com.jhlishero.code.generator.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;

public abstract class PropertiesLoaderUtils {
	
	public static Properties loadAllProperties(String resourceName) throws IOException {
		return loadAllProperties(resourceName, null);
	}

	public static Properties loadAllProperties(String resourceName, ClassLoader classLoader) throws IOException {
		if (resourceName == null || resourceName.trim().equals("")) {
			throw new IllegalArgumentException("Resource name must not be null");
		}
		ClassLoader clToUse = classLoader;
		if (clToUse == null) {
			clToUse = ClassUtils.getDefaultClassLoader();
		}
		
		Properties props = new Properties();
		Enumeration<URL> urls = clToUse.getResources(resourceName);
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			InputStream is = null;
			try {
				URLConnection con = url.openConnection();
				con.setUseCaches(false);
				is = con.getInputStream();
				props.load(is);
			} finally {
				if (is != null) {
					is.close();
				}
			}
		}
		
		return props;
	}
	
}
