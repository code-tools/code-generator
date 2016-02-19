package com.jumbo.tmalloms.manager.sales.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumbo.dao.sales.OrderToPacsDao;
import com.jumbo.tmalloms.manager.sales.manager.OrderToPacsManager;
import com.jumbo.tmalloms.manager.sales.vo.OrderToPacsVo;
import com.jumbo.tmalloms.manager.BaseManagerImpl;

/**
 * @author hailiang.jiang
 * @date 2015年09月03日 下午17:24:23
 */
@Service("orderToPacsManager")
@Transactional
public class OrderToPacsManagerImpl extends BaseManagerImpl implements OrderToPacsManager {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private OrderToPacsDao orderToPacsDao;

	@Override
	public OrderToPacsVo initPage(Long ouId) {
		// TODO Auto-generated method stub
		return null;
	}

}
