package com.noaa.tcdis.restserver.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noaa.tcdis.restserver.dao.ReturnSimlarTyphoonMapper;
import com.noaa.tcdis.restserver.service.ReturnSimlarTyphoonService;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceBodyVo;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceHeaderVo;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceParameterBodyVo;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceParameterVo;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceResTyphoonInfoVo;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceReturnVo;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceTyphoonDamage;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceTyphoonTrack;
import com.noaa.tcdis.restserver.vo.SimilarListVo;
import com.noaa.tcdis.restserver.vo.TyphoonDamageParamVo;
import com.noaa.tcdis.restserver.vo.TyphoonTrackListParamVo;

@Service("returnSimlarTyphoonService")
public class ReturnSimlarTyphoonServiceImpl implements ReturnSimlarTyphoonService{
	@Autowired
	ReturnSimlarTyphoonMapper returnSimlarTyphoonMapper;
	
	public String getTodayTime() {
		
		Calendar toDayTime = Calendar.getInstance();
		String timestamp;
		timestamp = String.valueOf(toDayTime.get(Calendar.YEAR)) + "-";
		timestamp +=String.valueOf(toDayTime.get(Calendar.MONTH)+1)+ "-";
		timestamp +=String.valueOf(toDayTime.get(Calendar.DAY_OF_MONTH))+ " ";
		
		timestamp +=String.valueOf(toDayTime.get(Calendar.HOUR_OF_DAY))+  ":";
		timestamp +=String.valueOf(toDayTime.get(Calendar.MINUTE))+  ":";
		timestamp +=String.valueOf(toDayTime.get(Calendar.SECOND));
		
		return timestamp;
	}
	
	@Override
	public CrewCntOnboardServiceReturnVo selectSimlarTyphoonList(CrewCntOnboardServiceParameterVo param)
			throws Exception {
		
		CrewCntOnboardServiceReturnVo returnVo = new CrewCntOnboardServiceReturnVo();
		CrewCntOnboardServiceHeaderVo paramHeaderVo = param.getHeader();
		CrewCntOnboardServiceParameterBodyVo paramBodyVo = param.getBody();	
		
		CrewCntOnboardServiceBodyVo bodyVo = new CrewCntOnboardServiceBodyVo();
		
		returnVo.setHeader(paramHeaderVo);
				
		bodyVo.setReqTimestamp(paramBodyVo.getReqTimestamp());
		bodyVo.setResTimestamp(getTodayTime());
		bodyVo.setResTyphOption(paramBodyVo.getReqTyphnOption());
		
		List<SimilarListVo> similarIdList = returnSimlarTyphoonMapper.findToSimlilarIdListByTyphoonName(paramBodyVo.getReqTyphnInfo().getTyphnTrackName());
		
		bodyVo.setResTyphnCount(similarIdList.size());
		
		List<CrewCntOnboardServiceResTyphoonInfoVo> typhoonInfoVoList = new ArrayList<CrewCntOnboardServiceResTyphoonInfoVo>();
		if(bodyVo !=null && similarIdList.size() > 0){
			for(int i= 0 ; i < similarIdList.size();i++){
				CrewCntOnboardServiceResTyphoonInfoVo typhoonInfo = new CrewCntOnboardServiceResTyphoonInfoVo();
				typhoonInfo.setTyphnName(similarIdList.get(i).getEngTyphoonName());
				TyphoonTrackListParamVo paramVo = new TyphoonTrackListParamVo();
				
				paramVo.setEngTyphoonName(similarIdList.get(i).getEngTyphoonName());
				paramVo.setDepth(paramBodyVo.getReqTyphnInfo().getTyphnTrackDepth());
				paramVo.setTyphoonId(similarIdList.get(i).getSimilarId());
				paramVo.setYear(similarIdList.get(i).getYear());
				
				int year  = Integer.parseInt(similarIdList.get(i).getYear());
				List<CrewCntOnboardServiceTyphoonTrack> typhoonTrackList = new ArrayList<CrewCntOnboardServiceTyphoonTrack>();
				if( year >2011){
					typhoonTrackList = returnSimlarTyphoonMapper.selectTyphoonTrackToInfoKma(paramVo);	
				}else{
					typhoonTrackList =  returnSimlarTyphoonMapper.selectTyphoonTrackToInfo(paramVo);	
				}
					
				int endSize = typhoonTrackList.size() - 1;
				String eDate = typhoonTrackList.get(0).getTimestamp().replace("-", "").substring(0,8);
				String sDate = typhoonTrackList.get(endSize).getTimestamp().replaceAll("-", "").substring(0,8);
				typhoonInfo.setTyphnTrackDepth(String.valueOf(typhoonTrackList.size()));
				TyphoonDamageParamVo damageParam = new TyphoonDamageParamVo();
				
				damageParam.setEDate(eDate);
				damageParam.setSDate(sDate);
				
				List<CrewCntOnboardServiceTyphoonDamage> damageList = returnSimlarTyphoonMapper.selectYyphoonDamage(damageParam);
				
				typhoonInfo.setTyphnDamage(damageList);
				typhoonInfo.setTyphnTrack(typhoonTrackList);
				typhoonInfoVoList.add(typhoonInfo);
			}
			
			bodyVo.setResTyphnInfo(typhoonInfoVoList);
			
		}
		
		
		returnVo.setBody(bodyVo);
		
		
		
		return returnVo;
		
	} 
	
	

}
