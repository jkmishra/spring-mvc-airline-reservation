package com.gamma.air.domain;

public class ErrorResponse {
	private String respMessage;
	
	public ErrorResponse(){
		
	}
	
	public ErrorResponse(String message){
		this.respMessage=message;
	}

	public String getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}
	
	

}
