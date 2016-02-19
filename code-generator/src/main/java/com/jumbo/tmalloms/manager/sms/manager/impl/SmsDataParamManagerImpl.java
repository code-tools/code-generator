package com.jumbo.tmalloms.manager.sms.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jumbo.dao.sms.SmsDataParamDao;
import com.jumbo.tmalloms.manager.sms.manager.SmsDataParamManager;
import com.jumbo.tmalloms.manager.sms.vo.SmsDataParamVo;
import com.jumbo.tmalloms.manager.BaseManagerImpl;

/**
 * @author hailiang.jiang
 * @date 2015年09月25日 下午13:32:18
 */
@Service("smsDataParamManager")
@Transactional
public class SmsDataParamManagerImpl extends BaseManagerImpl implements SmsDataParamManager {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SmsDataParamDao smsDataParamDao;

	@Override
	public SmsDataParamVo initPage(Long ouId) {
		// TODO Auto-generated method stub
		return null;
	}

}
