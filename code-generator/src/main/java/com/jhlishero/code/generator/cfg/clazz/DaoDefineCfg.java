package com.jhlishero.code.generator.cfg.clazz;

public class DaoDefineCfg extends ClassDefineCfg {
	private String importEntityPackageName;
	private String actualGenericType;

	public String getImportEntityPackageName() {
		return importEntityPackageName;
	}

	public void setImportEntityPackageName(String importEntityPackageName) {
		this.importEntityPackageName = importEntityPackageName;
	}

	public String getActualGenericType() {
		return actualGenericType;
	}

	public void setActualGenericType(String actualGenericType) {
		this.actualGenericType = actualGenericType;
	}
}
