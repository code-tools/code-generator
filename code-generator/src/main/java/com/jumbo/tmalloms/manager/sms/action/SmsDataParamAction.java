package com.jumbo.tmalloms.manager.sms.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.jumbo.tmalloms.manager.sms.cond.SmsDataParamCond;
import com.jumbo.tmalloms.manager.sms.manager.SmsDataParamManager;
import com.jumbo.tmalloms.manager.sms.vo.SmsDataParamVo;
import com.jumbo.web.action.BaseJQGridProfileAction;

/**
 * @author hailiang.jiang
 * @date 2015年09月25日 下午13:32:18
 */
public class SmsDataParamAction extends BaseJQGridProfileAction {
	
	private SmsDataParamVo vo;
	private SmsDataParamCond cond;
	
	@Autowired
	private SmsDataParamManager smsDataParamManager;


	@Override
	public String execute() throws Exception {
		this.vo = smsDataParamManager.initPage(0L);
		return SUCCESS;
	}


	public SmsDataParamVo getVo() {
		return vo;
	}

	public void setVo(SmsDataParamVo vo) {
		this.vo = vo;
	}

	public SmsDataParamCond getCond() {
		return cond;
	}

	public void setCond(SmsDataParamCond cond) {
		this.cond = cond;
	}
}
