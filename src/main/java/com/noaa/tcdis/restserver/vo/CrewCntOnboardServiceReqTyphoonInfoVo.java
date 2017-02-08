package com.noaa.tcdis.restserver.vo;

import java.util.List;

import lombok.Data;

@Data
public class CrewCntOnboardServiceReqTyphoonInfoVo {
	String typhnTrackName;
	String typhnTrackDepth;
	List<CrewCntOnboardServiceTyphoonTrackInfoVo> typhnTrackInfo;
	
	
}
