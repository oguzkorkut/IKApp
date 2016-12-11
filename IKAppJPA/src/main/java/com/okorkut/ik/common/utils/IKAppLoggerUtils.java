package com.okorkut.ik.common.utils;

import org.apache.log4j.Logger;

public class IKAppLoggerUtils {

	private static final Logger logger = Logger.getLogger(IKAppLoggerUtils.class);
		
	public <T> void loggerObj(Object obj,Class<T> type) throws Exception{
			
			if (obj != null) {
				if (logger.isDebugEnabled()) {
					logger.debug("ClassName:" + type.getName() +" - " + obj.toString());
				}
			}
			
		}
	}
