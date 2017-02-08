package com.noaa.tcdis.restserver.vo;

import lombok.Data;

@Data
public class TyphoonTrackListParamVo {
	
	String typhoonId;
	String year;
	String depth;
	String engTyphoonName;

}
