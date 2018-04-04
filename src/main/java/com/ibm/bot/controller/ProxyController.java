package com.ibm.bot.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class ProxyController {

	@RequestMapping(value = "/proxy", 
			method = POST, 
			consumes="application/json",
			produces="application/json")	
	@ResponseBody
	public String interceptRequest(@RequestBody String request){
		 RestTemplate restTemplate = new RestTemplate();
		 
		 return restTemplate.postForObject("https://travelbot.w3ibm.mybluemix.net/api/message", request, String.class);
	}
}
