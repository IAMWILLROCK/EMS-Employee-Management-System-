package com.luv2code.springdemo.dto;

import java.util.ArrayList;
import java.util.List;

public class ChatbotResponseDto {

	private List<ChatbotReplyDto> replies = new ArrayList<>();
	
	public ChatbotResponseDto(){
		
	}

	public List<ChatbotReplyDto> getReplies() {
		return replies;
	}

	public void setReplies(List<ChatbotReplyDto> replies) {
		this.replies = replies;
	}
	
	
}
