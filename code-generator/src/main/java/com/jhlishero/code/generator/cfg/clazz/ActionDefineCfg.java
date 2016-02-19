package com.jhlishero.code.generator.cfg.clazz;

public class ActionDefineCfg extends ClassDefineCfg {
	
	public ActionDefineCfg(ClassDefineCfg cdc) {
		super.packageQualifiedName = cdc.getPackageQualifiedName();
		super.className = cdc.getClassName();
	}

}
