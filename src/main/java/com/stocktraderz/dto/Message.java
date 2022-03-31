package com.stocktraderz.dto;

public class Message {
	private String messages;

	public String getMessage() {
		return messages;
	}

	public void setMessage(String message) {
		this.messages = message;
	}

	public Message(String message) {
		this.messages = message;
	}

	@Override
	public String toString() {
		return "Message [message=" + messages + "]";
	}

	public Message() {
	}
	
	
}
