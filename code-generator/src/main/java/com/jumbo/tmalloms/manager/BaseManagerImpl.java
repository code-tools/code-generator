/**
 * Copyright (c) 2010 Jumbomart All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Jumbomart. You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jumbo.
 * 
 * JUMBOMART MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. JUMBOMART SHALL NOT BE LIABLE FOR ANY
 * DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES.
 * 
 */

package com.jumbo.tmalloms.manager;

import java.util.Locale;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.jumbo.exception.BusinessException;

public abstract class BaseManagerImpl implements BaseManager {
    private static final long serialVersionUID = 13056181500802085L;

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    
    @Resource
    protected ApplicationContext applicationContext;
    
    protected String getMessage(String key, Object... args) {
        String message = null;
        try {
        	message = applicationContext.getMessage(key, args, Locale.SIMPLIFIED_CHINESE);
        } catch(Exception e) {
        	log.error("--------------- message code not existed: " + key + " ----------------");
        }
        return message == null ? "" : message;
    }
    
    protected String getBusinessExceptionMessage(BusinessException be) {
    	String errorMsg = "";
        return errorMsg;
    }
}
