package com.ibm.bot.utils;

import java.util.concurrent.ConcurrentHashMap;

import com.ibm.watson.developer_cloud.conversation.v1.model.Context;

public class ContextHandler {
	
	
//HashMap key email , context 
	
	private static final ContextHandler contextHandler = new ContextHandler();
	private ConcurrentHashMap<String, Context> catchedContext = new ConcurrentHashMap<String,Context>();
	
	protected ContextHandler() {
		
	}
	
	public static ContextHandler getContextHandler() {
		
		return contextHandler;
	}
	
	public void addToCatchedContext(String email, Context ctx) {
		this.catchedContext.putIfAbsent(email, ctx);
	}
	
	public Context getCatchedContextByEmail(String email) {
		return this.catchedContext.get(email);
	}
	
	public void removeFromCatchedContext(String email) {
		this.catchedContext.remove(email);
	}

	public ConcurrentHashMap<String, Context> getCatchedContext() {
		return catchedContext;
	}
	
	
}
