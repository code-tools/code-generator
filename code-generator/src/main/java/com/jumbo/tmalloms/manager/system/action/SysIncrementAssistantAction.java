package com.jumbo.tmalloms.manager.system.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.jumbo.tmalloms.manager.system.cond.SysIncrementAssistantCond;
import com.jumbo.tmalloms.manager.system.manager.SysIncrementAssistantManager;
import com.jumbo.tmalloms.manager.system.vo.SysIncrementAssistantVo;
import com.jumbo.web.action.BaseJQGridProfileAction;

/**
 * @author hailiang.jiang
 * @date 2015年11月26日 上午10:37:06
 */
public class SysIncrementAssistantAction extends BaseJQGridProfileAction {
	
	private SysIncrementAssistantVo vo;
	private SysIncrementAssistantCond cond;
	
	@Autowired
	private SysIncrementAssistantManager sysIncrementAssistantManager;


	@Override
	public String execute() throws Exception {
		this.vo = sysIncrementAssistantManager.initPage(0L);
		return SUCCESS;
	}


	public SysIncrementAssistantVo getVo() {
		return vo;
	}

	public void setVo(SysIncrementAssistantVo vo) {
		this.vo = vo;
	}

	public SysIncrementAssistantCond getCond() {
		return cond;
	}

	public void setCond(SysIncrementAssistantCond cond) {
		this.cond = cond;
	}
}
