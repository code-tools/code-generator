package com.jumbo.tmalloms.manager.sms.manager;

import com.jumbo.tmalloms.manager.sms.vo.SmsDataParamDtVo;
import com.jumbo.tmalloms.manager.BaseManager;

/**
 * @author hailiang.jiang
 * @date 2015年09月25日 下午13:33:58
 */
public interface SmsDataParamDtManager extends BaseManager {

	/**
	 * 初始化页面
	 * @author hailiang.jiang
	 * @date 2015年09月25日 下午13:33:58
	 * @param ouId
	 * @return
	 */
	public SmsDataParamDtVo initPage(Long ouId);
	
}
