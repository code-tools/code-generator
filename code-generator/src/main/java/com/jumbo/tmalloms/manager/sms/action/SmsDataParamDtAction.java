package com.jumbo.tmalloms.manager.sms.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.jumbo.tmalloms.manager.sms.cond.SmsDataParamDtCond;
import com.jumbo.tmalloms.manager.sms.manager.SmsDataParamDtManager;
import com.jumbo.tmalloms.manager.sms.vo.SmsDataParamDtVo;
import com.jumbo.web.action.BaseJQGridProfileAction;

/**
 * @author hailiang.jiang
 * @date 2015年09月25日 下午13:33:58
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
