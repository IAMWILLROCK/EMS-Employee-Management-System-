package com.luv2code.springdemo.dto;

public class ChatbotReplyDto {

	private String type;
	private String content;
	
	public ChatbotReplyDto(){
		
	}

	public ChatbotReplyDto(String type, String content) {
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
