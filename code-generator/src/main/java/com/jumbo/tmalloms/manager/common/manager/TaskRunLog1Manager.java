package com.jumbo.tmalloms.manager.common.manager;

import com.jumbo.tmalloms.manager.common.vo.TaskRunLog1Vo;
import com.jumbo.tmalloms.manager.BaseManager;

/**
 * @author hailiang.jiang
 * @date 2015年09月02日 下午17:27:31
 */
public interface TaskRunLog1Manager extends BaseManager {

	/**
	 * 初始化页面
	 * @author hailiang.jiang
	 * @date 2015年09月02日 下午17:27:31
	 * @param ouId
	 * @return
	 */
	public TaskRunLog1Vo initPage(Long ouId);
	
}
