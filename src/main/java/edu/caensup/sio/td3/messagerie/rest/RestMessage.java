package edu.caensup.sio.td3.messagerie.rest;

public class RestMessage {

	private String type;
	private String content;
	
	public RestMessage(String type, String content) {
		
		this.type = type;
		this.content = content;
		
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
}
