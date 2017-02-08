package com.noaa.tcdis.restserver.vo;

import lombok.Data;

@Data
public class CrewCntOnboardServiceTyphoonTrack {
	String timestamp;
	String lat;
	String lon;
	String atm;
	String windms;
	String windkmh;
	String direction;
	String speed;
	
	
}
