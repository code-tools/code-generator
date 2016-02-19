package com.jumbo.tmalloms.manager.system.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.jumbo.tmalloms.manager.system.cond.SmsDataParamDtCond;
import com.jumbo.tmalloms.manager.system.manager.SmsDataParamDtManager;
import com.jumbo.tmalloms.manager.system.vo.SmsDataParamDtVo;
import com.jumbo.web.action.BaseJQGridProfileAction;

/**
 * @author hailiang.jiang
 * @date 2015年11月26日 上午10:35:23
 */
public class SmsDataParamDtAction extends BaseJQGridProfileAction {
	
	private SmsDataParamDtVo vo;
	private SmsDataParamDtCond cond;
	
	@Autowired
	private SmsDataParamDtManager smsDataParamDtManager;


	@Override
	public String execute() throws Exception {
		this.vo = smsDataParamDtManager.initPage(0L);
		return SUCCESS;
	}


	public SmsDataParamDtVo getVo() {
		return vo;
	}

	public void setVo(SmsDataParamDtVo vo) {
		this.vo = vo;
	}

	public SmsDataParamDtCond getCond() {
		return cond;
	}

	public void setCond(SmsDataParamDtCond cond) {
		this.cond = cond;
	}
}
