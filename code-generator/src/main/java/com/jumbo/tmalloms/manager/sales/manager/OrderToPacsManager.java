package com.jumbo.tmalloms.manager.sales.manager;

import com.jumbo.tmalloms.manager.sales.vo.OrderToPacsVo;
import com.jumbo.tmalloms.manager.BaseManager;

/**
 * @author hailiang.jiang
 * @date 2015年09月03日 下午17:24:23
 */
public interface OrderToPacsManager extends BaseManager {

	/**
	 * 初始化页面
	 * @author hailiang.jiang
	 * @date 2015年09月03日 下午17:24:23
	 * @param ouId
	 * @return
	 */
	public OrderToPacsVo initPage(Long ouId);
	
}
