package com.jumbo.tmalloms.manager.system.manager;

import com.jumbo.tmalloms.manager.system.vo.SysIncrementAssistantVo;
import com.jumbo.tmalloms.manager.BaseManager;

/**
 * @author hailiang.jiang
 * @date 2015年11月26日 上午10:37:06
 */
public interface SysIncrementAssistantManager extends BaseManager {

	/**
	 * 初始化页面
	 * @author hailiang.jiang
	 * @date 2015年11月26日 上午10:37:06
	 * @param ouId
	 * @return
	 */
	public SysIncrementAssistantVo initPage(Long ouId);
	
}
