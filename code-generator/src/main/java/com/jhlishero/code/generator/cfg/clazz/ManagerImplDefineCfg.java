package com.jhlishero.code.generator.cfg.clazz;

public class ManagerImplDefineCfg extends ClassDefineCfg {
	
	public ManagerImplDefineCfg(ClassDefineCfg cdc) {
		super.packageQualifiedName = cdc.getPackageQualifiedName();
		super.className = cdc.getClassName();
	}

}
