package com.ibm.bot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ibm.bot.model.Message;
import com.ibm.bot.model.MessageRequestWrapper;
import com.ibm.bot.model.MessageResponseWrapper;
import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import static com.ibm.watson.developer_cloud.conversation.v1.Conversation.*;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import static com.ibm.bot.utils.Constants.*;

@Service
public class WatsonConversationService{
	
	private static final Logger log = LoggerFactory.getLogger(WatsonConversationService.class);

	/**
	 * Just for test
	 */
	public Message communicate(Message mes){
		log.info("Received message: "+mes);
		return new Message(mes.getMessage(), mes.getSender());
	}
	
	/**
	 * Here we call the Watson conversation handler
	 */
	public MessageResponse sendMessage(MessageRequestWrapper reqMsg) {
		log.info("Input message sent to Watson: "+reqMsg.getMsg());
		InputData input = new InputData.Builder(reqMsg.getMsg()).build();
		MessageOptions options = new MessageOptions.Builder(WORKSPACE_ID)
													.input(input)
													.context(reqMsg.getContext())
													.build();

		MessageResponse response = getConversation().message(options).execute();
		log.info("Response message from Watson: "+response.getOutput().getText());
		
		return response;
	}
	
	private Conversation getConversation(){
		Conversation conversation = new Conversation(VERSION_DATE_2017_05_26);
		conversation.setUsernameAndPassword(USER,PASSWORD);		
		return conversation;
	}
}