package ${actionCfg.packageQualifiedName};

import org.springframework.beans.factory.annotation.Autowired;

import ${condCfg.packageQualifiedName}.${condCfg.className};
import ${managerCfg.packageQualifiedName}.${managerCfg.className};
import ${voCfg.packageQualifiedName}.${voCfg.className};
import com.jumbo.web.action.BaseJQGridProfileAction;

/**
 * @author ${clazzCmt.author}
 * @date ${clazzCmt.date}
 */
public class ${actionCfg.className} extends BaseJQGridProfileAction {
	
	private ${voCfg.className} vo;
	private ${condCfg.className} cond;
	
	@Autowired
	private ${managerCfg.className} ${managerCfg.className?uncap_first};


	@Override
	public String execute() throws Exception {
		this.vo = ${managerCfg.className?uncap_first}.initPage(0L);
		return SUCCESS;
	}


	public ${voCfg.className} getVo() {
		return vo;
	}

	public void setVo(${voCfg.className} vo) {
		this.vo = vo;
	}

	public ${condCfg.className} getCond() {
		return cond;
	}

	public void setCond(${condCfg.className} cond) {
		this.cond = cond;
	}
}
