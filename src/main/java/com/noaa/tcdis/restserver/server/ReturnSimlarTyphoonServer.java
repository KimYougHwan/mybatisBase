package com.noaa.tcdis.restserver.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.noaa.tcdis.restserver.service.ReturnSimlarTyphoonService;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceParameterVo;
import com.noaa.tcdis.restserver.vo.CrewCntOnboardServiceReturnVo;

@RestController
public class ReturnSimlarTyphoonServer {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ReturnSimlarTyphoonService returnSimlarTyphoonService;
	
	@RequestMapping(value= "/crewCntOnboardService.do" ,method=RequestMethod.POST)
	public CrewCntOnboardServiceReturnVo crewCntOnboardService(@RequestBody CrewCntOnboardServiceParameterVo parameterVo) {
		CrewCntOnboardServiceReturnVo result = new CrewCntOnboardServiceReturnVo();
		
		
		try {
			result = returnSimlarTyphoonService.selectSimlarTyphoonList(parameterVo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
}
