package com.jhlishero.code.generator.cfg.clazz;

public class ManagerDefineCfg extends ClassDefineCfg {
	private String importEntityPackageName;
	private String actualGenericType;

	public ManagerDefineCfg(ClassDefineCfg cdc) {
		super.packageQualifiedName = cdc.getPackageQualifiedName();
		super.className = cdc.getClassName();
	}

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
