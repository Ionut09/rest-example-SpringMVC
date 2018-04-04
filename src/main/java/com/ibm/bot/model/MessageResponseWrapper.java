package com.ibm.bot.model;

import java.util.List;

public class MessageResponseWrapper {
	
	private List<String> msgResponse;
	private String email;

	public MessageResponseWrapper(List<String> msgResponse, String email) {
		this.msgResponse = msgResponse;
		this.email = email;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}


	public List<String> getMsgResponse() {
		return msgResponse;
	}


	public void setMsgResponse(List<String> msgResponse) {
		this.msgResponse = msgResponse;
	}
	
	
}
