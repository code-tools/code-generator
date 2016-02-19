package com.jumbo.tmalloms.manager.common.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.jumbo.tmalloms.manager.common.cond.TaskRunLog1Cond;
import com.jumbo.tmalloms.manager.common.manager.TaskRunLog1Manager;
import com.jumbo.tmalloms.manager.common.vo.TaskRunLog1Vo;
import com.jumbo.web.action.BaseJQGridProfileAction;

/**
 * @author hailiang.jiang
 * @date 2015年09月02日 下午17:27:31
 */
public class TaskRunLog1Action extends BaseJQGridProfileAction {
	
	private TaskRunLog1Vo vo;
	private TaskRunLog1Cond cond;
	
	@Autowired
	private TaskRunLog1Manager taskRunLog1Manager;


	@Override
	public String execute() throws Exception {
		this.vo = taskRunLog1Manager.initPage(0L);
		return SUCCESS;
	}


	public TaskRunLog1Vo getVo() {
		return vo;
	}

	public void setVo(TaskRunLog1Vo vo) {
		this.vo = vo;
	}

	public TaskRunLog1Cond getCond() {
		return cond;
	}

	public void setCond(TaskRunLog1Cond cond) {
		this.cond = cond;
	}
}
