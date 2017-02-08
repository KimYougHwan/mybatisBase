package com.noaa.tcdis.restserver.vo;

import java.util.List;

import lombok.Data;

@Data
public class CrewCntOnboardServiceResTyphoonInfoVo {
	String typhnTrackDepth;
	String typhnName;
	List<CrewCntOnboardServiceTyphoonTrack> typhnTrack;
	List<CrewCntOnboardServiceTyphoonDamage> typhnDamage;
}
