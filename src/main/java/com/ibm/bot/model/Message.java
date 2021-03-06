package com.ibm.bot.model;

public class Message {

	private String message;
	private String sender;
	
	public Message(){
		
	}

	public Message(String message, String sender) {
		super();
		this.message = message;
		this.sender = sender;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", sender=" + sender + "]";
	}
	
	
}
