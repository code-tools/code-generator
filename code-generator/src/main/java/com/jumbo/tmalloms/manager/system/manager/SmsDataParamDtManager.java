package com.jumbo.tmalloms.manager.system.manager;

import com.jumbo.tmalloms.manager.system.vo.SmsDataParamDtVo;
import com.jumbo.tmalloms.manager.BaseManager;

/**
 * @author hailiang.jiang
 * @date 2015年11月26日 上午10:35:23
 */
public interface SmsDataParamDtManager extends BaseManager {

	/**
	 * 初始化页面
	 * @author hailiang.jiang
	 * @date 2015年11月26日 上午10:35:23
	 * @param ouId
	 * @return
	 */
	public SmsDataParamDtVo initPage(Long ouId);
	
}
