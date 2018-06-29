package com.stkj.modules.endpoint.service;

public interface WebControlService {
	void connect();	 
	String SendAndGetMessage(String message);
	void closeconnect();
}
