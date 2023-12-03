package com.service.com.dto;

import com.service.com.enums.StatusEnum;

import lombok.Data;

@Data
public class Message {
	private StatusEnum status;
	private String message;
	private Object data;
	
}
