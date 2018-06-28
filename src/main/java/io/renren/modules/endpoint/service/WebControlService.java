package io.renren.modules.endpoint.service;

public interface WebControlService {
	void connect();	 
	String SendAndGetMessage(String message);
	void closeconnect();
}
