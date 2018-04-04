package com.ibm.bot.model;

import com.ibm.watson.developer_cloud.conversation.v1.model.Context;

public class MessageRequestWrapper {
	
	private String msg;
	private String email;
	private Context context;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	

}
