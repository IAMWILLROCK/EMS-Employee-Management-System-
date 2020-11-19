package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.dto.ChatbotReplyDto;
import com.luv2code.springdemo.dto.ChatbotResponseDto;

@RestController
@RequestMapping("/chatbot")
public class ChatbotConversationController {
	
	@GetMapping("/hi")
	public ChatbotResponseDto sendAnswer(){
		
		ChatbotResponseDto response = new ChatbotResponseDto();
		List<ChatbotReplyDto> replies = new ArrayList<>();
		ChatbotReplyDto tester = new ChatbotReplyDto("text","Suck it");
		replies.add(tester);
		response.setReplies(replies);
		return response;
	}
	
	@GetMapping("/action")
	public String doWork(){
		return "IT is working";
	}
}
