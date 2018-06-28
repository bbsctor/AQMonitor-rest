package com.stkj.AQMonitor.module.endpoint.service;

public interface WebConnectService {
	
	void connect();	 
	String SendAndGetMessage(String message);
	void closeconnect();

}
