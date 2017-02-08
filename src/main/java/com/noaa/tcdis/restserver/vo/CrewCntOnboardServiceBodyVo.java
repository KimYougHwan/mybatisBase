package com.noaa.tcdis.restserver.vo;

import java.util.List;

import lombok.Data;

@Data
public class CrewCntOnboardServiceBodyVo {
	String reqTimestamp;
	String resTimestamp;
	CrewCntOnboardServiceReqTypeOptionVo resTyphOption;
	int resTyphnCount;
	List<CrewCntOnboardServiceResTyphoonInfoVo> resTyphnInfo;
}
