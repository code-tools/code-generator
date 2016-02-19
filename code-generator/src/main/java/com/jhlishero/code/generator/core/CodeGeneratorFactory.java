package com.jhlishero.code.generator.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.jhlishero.code.generator.cfg.clazz.ActionDefineCfg;
import com.jhlishero.code.generator.cfg.clazz.ClassDefineCfg;
import com.jhlishero.code.generator.cfg.clazz.DaoDefineCfg;
import com.jhlishero.code.generator.cfg.clazz.EntityDefineCfg;
import com.jhlishero.code.generator.cfg.clazz.ManagerDefineCfg;
import com.jhlishero.code.generator.cfg.clazz.ManagerImplDefineCfg;
import com.jhlishero.code.generator.cfg.comment.ClassComment;
import com.jhlishero.code.generator.constant.Constant;
import com.jhlishero.code.generator.util.DateUtils;
import com.jhlishero.code.generator.util.FileUtils;
import com.jhlishero.code.generator.util.PathUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CodeGeneratorFactory {

	public static void generate() throws IOException {
		Configuration cfg = FreeMarkerFactory.newInstance();
		EntityDefineCfg edc = generateEntityBean(cfg);
		DaoDefineCfg daoCfg = generateDao(cfg, edc);
		ClassDefineCfg condCfg = generateEntityBean(cfg, "cond", Constant.PROPS_CFG_FTL_NAME_COND);
		ClassDefineCfg voCfg = generateEntityBean(cfg, "vo", Constant.PROPS_CFG_FTL_NAME_VO);
		ManagerDefineCfg mdcCfg = generateManager(cfg, voCfg, Constant.PROPS_CFG_FTL_NAME_MANAGER);
		generateManagerImpl(cfg, mdcCfg, daoCfg, voCfg, Constant.PROPS_CFG_FTL_NAME_MANAGER_IMPL);
		generateAction(cfg, mdcCfg, voCfg, condCfg, Constant.PROPS_CFG_FTL_NAME_ACTION);
	}
	
	private static void generateAction(Configuration cfg, ManagerDefineCfg mdcCfg, ClassDefineCfg voCfg, ClassDefineCfg condCfg, String templateFtl) throws IOException {
		ActionDefineCfg adcCfg = new ActionDefineCfg(getClassDefineCfg("action"));
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("actionCfg", adcCfg);
		root.put("managerCfg", mdcCfg);
		root.put("clazzCmt", getClassComment());
		root.put("managerCfg", mdcCfg);
		root.put("voCfg", voCfg);
		root.put("condCfg", condCfg);
		
		String daoFullPath = FileUtils.createDir(PathUtils.getMavenProjectSourceCodeRootDir(), adcCfg.getPackageQualifiedName().replace(".", File.separator));
		String classFile = daoFullPath + File.separator + adcCfg.getClassName() + ".java";
		
		generate(cfg, classFile, templateFtl, root);
	}

	private static ManagerImplDefineCfg generateManagerImpl(Configuration cfg, ManagerDefineCfg mdcCfg, DaoDefineCfg daoCfg, ClassDefineCfg voCfg, String templateFtl) throws IOException {
		ManagerImplDefineCfg midc = new ManagerImplDefineCfg(getClassDefineCfg("manager.impl"));
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("managerImplCfg", midc);
		root.put("clazzCmt", getClassComment());
		root.put("managerCfg", mdcCfg);
		root.put("daoCfg", daoCfg);
		root.put("voCfg", voCfg);
		
		String daoFullPath = FileUtils.createDir(PathUtils.getMavenProjectSourceCodeRootDir(), midc.getPackageQualifiedName().replace(".", File.separator));
		String classFile = daoFullPath + File.separator + midc.getClassName() + ".java";
		
		generate(cfg, classFile, templateFtl, root);
		
		return midc;
	}

	private static ManagerDefineCfg generateManager(Configuration cfg, ClassDefineCfg vo, String templateFtl) throws IOException {
		// 创建数据模型
		ManagerDefineCfg mdc = new ManagerDefineCfg(getClassDefineCfg("manager"));
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("clazzCfg", mdc);
		root.put("clazzCmt", getClassComment());
		root.put("classVo", vo);
		
		String daoFullPath = FileUtils.createDir(PathUtils.getMavenProjectSourceCodeRootDir(), mdc.getPackageQualifiedName().replace(".", File.separator));
		String classFile = daoFullPath + File.separator + mdc.getClassName() + ".java";
		
		generate(cfg, classFile, templateFtl, root);
		
		return mdc;
	}

	/**
	 * 生成实体bean
	 * @author hailiang.jiang
	 * @date 2015年4月1日 下午4:23:21
	 * @param cfg
	 * @param postfix
	 * @throws IOException 
	 */
	private static ClassDefineCfg generateEntityBean(Configuration cfg, String postfix, String templateFtl) throws IOException {
		// 创建数据模型
		ClassDefineCfg cdc = getClassDefineCfg(postfix);
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("clazzCfg", cdc);
		root.put("clazzCmt", getClassComment());
		
		String daoFullPath = FileUtils.createDir(PathUtils.getMavenProjectSourceCodeRootDir(), cdc.getPackageQualifiedName().replace(".", File.separator));
		String classFile = daoFullPath + File.separator + cdc.getClassName() + ".java";
		
		generate(cfg, classFile, templateFtl, root);
		
		return cdc;
	}

	public static EntityDefineCfg getEntityDefineCfg() {
		// 创建Entity实体类
		EntityDefineCfg edc = new EntityDefineCfg();
		edc.setPackageQualifiedName(FreeMarkerFactory.CLAZZ_PROPS.getProperty(Constant.PROPS_CLAZZ_ENTITY_PACKAGE));
		edc.setClassName(FreeMarkerFactory.CLAZZ_PROPS.getProperty(Constant.PROPS_CLAZZ_ENTITY_NAME));
		return edc;
	}
	
	public static DaoDefineCfg getDaoDefineCfg(EntityDefineCfg edc) {
		DaoDefineCfg ddCfg = new DaoDefineCfg();
		ddCfg.setPackageQualifiedName(FreeMarkerFactory.CLAZZ_PROPS.getProperty(Constant.PROPS_CLAZZ_DAO_PACKAGE));
		ddCfg.setActualGenericType(edc.getClassName());
		ddCfg.setClassName(ddCfg.getActualGenericType() + "Dao");
		ddCfg.setImportEntityPackageName(edc.getPackageQualifiedName() + "." + edc.getClassName());
		return ddCfg;
	}
	
	public static ClassComment getClassComment() {
		ClassComment clazzCmt = new ClassComment();
		clazzCmt.setAuthor(Constant.AUTHOR);
		clazzCmt.setDate(DateUtils.getCommentDate(new Date()));
		return clazzCmt;
	}
	
	public static DaoDefineCfg generateDao(Configuration cfg, EntityDefineCfg edc) throws IOException {
		// 创建数据模型
		DaoDefineCfg ddCfg = getDaoDefineCfg(edc);
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("daoCfg", ddCfg);
		root.put("clazzCmt", getClassComment());
		
		String daoFullPath = FileUtils.createDir(PathUtils.getMavenProjectSourceCodeRootDir(), ddCfg.getPackageQualifiedName().replace(".", File.separator));
		String daoClassFile = daoFullPath + File.separator + ddCfg.getClassName() + ".java";
		
		generate(cfg, daoClassFile, Constant.PROPS_CFG_FTL_NAME_DAO, root);
		
		return ddCfg;
	}
	
	public static EntityDefineCfg generateEntityBean(Configuration cfg) throws IOException {
		// 创建Entity实体类
		EntityDefineCfg edc = getEntityDefineCfg();
		// 类的位置
		String fullPath = FileUtils.createDir(PathUtils.getMavenProjectSourceCodeRootDir(), edc.getPackageQualifiedName().replace(".", File.separator));
		String clazzPathName = fullPath + File.separator + edc.getClassName() + ".java";
		
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("entityCfg", edc);
		
		generate(cfg, clazzPathName, Constant.PROPS_CFG_FTL_NAME_ENTITY, root);
		
		return edc;
	}
	
	public static ClassDefineCfg getClassDefineCfg(String clazzType) throws IOException {
		ClassDefineCfg cdc = new EntityDefineCfg();
		cdc.setPackageQualifiedName(FreeMarkerFactory.CLAZZ_PROPS.getProperty(Constant.PROPS_CLAZZ_BASE_PACKAGE) + "." + getPackagePostfix(clazzType));
		cdc.setClassName(FreeMarkerFactory.CLAZZ_PROPS.getProperty(Constant.PROPS_CLAZZ_BASE_CLAZZ_PREV) + getClazzPostfix(clazzType));
		return cdc; 
	}
	
	/**
	 * 
	 * @author hailiang.jiang
	 * @date 2015年4月1日 下午3:29:36
	 * @param cfg
	 * @param fileFullName
	 * @param templateName
	 * @param root
	 * @throws IOException
	 */
	public static void generate(Configuration cfg, String fileFullName, String templateName, Map<String, Object> root) throws IOException {
		Template tpl = cfg.getTemplate(FreeMarkerFactory.CFG_PROPS.getProperty(templateName));
		FileWriter entityWriter = new FileWriter(new File(fileFullName));
		try {
			tpl.process(root, entityWriter);
		} catch (TemplateException e) {
			e.printStackTrace();
		} finally {
			if (entityWriter != null) {
				entityWriter.flush();
				entityWriter.close();
			}
		}
	}
	
	
	/**
	 * 转换成类的后缀，如传入cond、Cond、COND，则转换成Cond, 若传入是manager.impl、Manager.IMPL，则转换为ManagerImpl
	 * @author hailiang.jiang
	 * @date 2015年4月1日 下午4:08:19
	 * @param clazzType
	 * @return
	 */
	private static String getClazzPostfix(String clazzType) {
		StringBuilder tempSb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(clazzType, ".");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			String firstChar = "" + token.charAt(0);
			tempSb.append(firstChar.toUpperCase() + token.substring(1));
		}
		
		return tempSb.toString();
	}
	
	private static String getPackagePostfix(String clazzType) {
		return clazzType.toLowerCase();
	}
	
	public static void main(String[] args) {
		System.out.println(getClazzPostfix("manager.impl"));
		System.out.println(getClazzPostfix("vo"));
		System.out.println(getClazzPostfix("cond"));
	}
	
}
