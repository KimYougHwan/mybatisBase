package com.noaa.tcdis.restserver.vo;

import lombok.Data;

@Data
public class CrewCntOnboardServiceParameterBodyVo {
	
	String reqTimestamp;
	CrewCntOnboardServiceReqTypeOptionVo reqTyphnOption;
	CrewCntOnboardServiceReqTyphoonInfoVo reqTyphnInfo;
	

}
