package com.ibm.bot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import com.ibm.bot.model.*;
import com.ibm.bot.service.WatsonConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

@RestController
@CrossOrigin
public class ChatBotController {

	@Autowired
	private WatsonConversationService ms;
	
	@RequestMapping(value = "/send", 
			method = POST, 
			consumes="application/json",
			produces="application/json")	
	@ResponseBody
	public Message receiveMessage(@RequestBody Message mes){
		return ms.communicate(mes);
	}
	
	
	@RequestMapping(value = "/message", 
					method = POST, 
					consumes="application/json",
					produces="application/json")	
	@ResponseBody
	public MessageResponse message(@RequestBody MessageRequestWrapper msgWrapper){
		return ms.sendMessage(msgWrapper);
	}
	
}
