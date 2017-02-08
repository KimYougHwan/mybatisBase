package com.noaa.tcdis.restserver.service;

import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceParameterVo;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceReturnVo;

public interface ReturnSimlarTyphoonService {
	
	public CrewCntOnboardServiceReturnVo selectSimlarTyphoonList(CrewCntOnboardServiceParameterVo param) throws Exception;
}
