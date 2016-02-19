package com.jumbo.tmalloms.manager.sms.manager;

import com.jumbo.tmalloms.manager.sms.vo.SmsDataParamVo;
import com.jumbo.tmalloms.manager.BaseManager;

/**
 * @author hailiang.jiang
 * @date 2015年09月25日 下午13:32:18
 */
public interface SmsDataParamManager extends BaseManager {

	/**
	 * 初始化页面
	 * @author hailiang.jiang
	 * @date 2015年09月25日 下午13:32:18
	 * @param ouId
	 * @return
	 */
	public SmsDataParamVo initPage(Long ouId);
	
}
