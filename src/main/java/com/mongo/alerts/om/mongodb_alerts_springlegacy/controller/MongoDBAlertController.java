package com.mongo.alerts.om.mongodb_alerts_springlegacy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Map;
import com.mongo.alerts.om.mongodb_alerts_springlegacy.model.AlertResponse;
@Controller
@RequestMapping(value = "/json")
public class MongoDBAlertController {
	
	@RequestMapping(value = "/javaClientAlert", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody AlertResponse javaClientAlert(@RequestBody Map<String, Object> alert) {

		AlertResponse alertResponse = new AlertResponse();
		String status = (String) alert.getOrDefault("status", "");
		String error = (String) alert.getOrDefault("error", "");
		
		if( status != null) {
			if(status.equalsIgnoreCase("open") || status.equalsIgnoreCase("tracking")) {
				alertResponse.setStatus("open");
				alertResponse.setError(error);
				return alertResponse;
			}
			
		}
		alertResponse.setStatus("close");
		alertResponse.setError(null);
		
		return alertResponse;
		
	
	}
	
	
	@RequestMapping(value = "/omAlert", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody AlertResponse omAlert(@RequestBody Map<String, Object> alert) {

		AlertResponse alertResponse = new AlertResponse();
		String status = (String) alert.getOrDefault("status", "");
		String error = (String) alert.getOrDefault("error", "");
		
		if( status != null) {
			if(status.equalsIgnoreCase("open") || status.equalsIgnoreCase("tracking")) {
				alertResponse.setStatus("open");
				alertResponse.setError(error);
			}
		}
		else {
			alertResponse.setStatus("closed");
		}
		return alertResponse;
		
	
	}
	
	
}
