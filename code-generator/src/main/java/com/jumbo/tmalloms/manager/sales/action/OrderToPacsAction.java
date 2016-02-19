package com.jumbo.tmalloms.manager.sales.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.jumbo.tmalloms.manager.sales.cond.OrderToPacsCond;
import com.jumbo.tmalloms.manager.sales.manager.OrderToPacsManager;
import com.jumbo.tmalloms.manager.sales.vo.OrderToPacsVo;
import com.jumbo.web.action.BaseJQGridProfileAction;

/**
 * @author hailiang.jiang
 * @date 2015年09月03日 下午17:24:23
 */
public class OrderToPacsAction extends BaseJQGridProfileAction {
	
	private OrderToPacsVo vo;
	private OrderToPacsCond cond;
	
	@Autowired
	private OrderToPacsManager orderToPacsManager;


	@Override
	public String execute() throws Exception {
		this.vo = orderToPacsManager.initPage(0L);
		return SUCCESS;
	}


	public OrderToPacsVo getVo() {
		return vo;
	}

	public void setVo(OrderToPacsVo vo) {
		this.vo = vo;
	}

	public OrderToPacsCond getCond() {
		return cond;
	}

	public void setCond(OrderToPacsCond cond) {
		this.cond = cond;
	}
}
