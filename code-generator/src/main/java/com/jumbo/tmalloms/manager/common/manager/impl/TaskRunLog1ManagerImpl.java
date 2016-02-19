package com.jumbo.tmalloms.manager.common.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumbo.dao.task.TaskRunLog1Dao;
import com.jumbo.tmalloms.manager.common.manager.TaskRunLog1Manager;
import com.jumbo.tmalloms.manager.common.vo.TaskRunLog1Vo;
import com.jumbo.tmalloms.manager.BaseManagerImpl;

/**
 * @author hailiang.jiang
 * @date 2015年09月02日 下午17:27:31
 */
@Service("taskRunLog1Manager")
@Transactional
public class TaskRunLog1ManagerImpl extends BaseManagerImpl implements TaskRunLog1Manager {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TaskRunLog1Dao taskRunLog1Dao;

	@Override
	public TaskRunLog1Vo initPage(Long ouId) {
		// TODO Auto-generated method stub
		return null;
	}

}
