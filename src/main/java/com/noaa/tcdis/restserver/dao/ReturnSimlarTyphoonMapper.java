package com.noaa.tcdis.restserver.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceTyphoonDamage;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceTyphoonTrack;
import com.noaa.tcdis.restserver.vo.SimilarListVo;
import com.noaa.tcdis.restserver.vo.TyphoonDamageParamVo;
import com.noaa.tcdis.restserver.vo.TyphoonTrackListParamVo;

@Repository(value = "returnSimlarTyphoonMapper")
public interface ReturnSimlarTyphoonMapper {

	@Select(" SELECT TYPHOON_ID FROM (SELECT TYPHOON_ID from TYPHOON_CODE WHERE ENG_TYPHOON_NAME =#{typhoonName} ORDER BY YEAR DESC  )WHERE ROWNUM = 1")
	public String findToIdByTyphoonName(String typhoonName) throws Exception;
	
	public List<SimilarListVo> findToSimlilarIdListByTyphoonName(String typhoonName) throws Exception;
	
	public List<CrewCntOnboardServiceTyphoonTrack> selectTyphoonTrackToInfoKma(TyphoonTrackListParamVo paramVo) throws Exception;
	public List<CrewCntOnboardServiceTyphoonTrack> selectTyphoonTrackToInfo(TyphoonTrackListParamVo paramVo) throws Exception;
	
	public List<CrewCntOnboardServiceTyphoonDamage> selectYyphoonDamage(TyphoonDamageParamVo paramVo) throws Exception;
}
