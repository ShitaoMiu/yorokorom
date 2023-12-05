package com.service.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.com.dto.LoginRequestDto;
import com.service.com.dto.Message;
import com.service.com.dto.StringMessage;
import com.service.com.enums.StatusEnum;
import com.service.com.service.BoardService;
import com.service.com.service.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class LoginController {
	private final BoardService boardService;
	private final PostService postService;

	@GetMapping("/loginAction")
	public ResponseEntity<Message> loginAction(@RequestBody LoginRequestDto loginRequestDto) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();
        System.out.println(username);
        System.out.println(password);
         
        
        
        
		Message message = new Message();
		message.setStatus(StatusEnum.OK);
		message.setMessage(StringMessage.workComplete);
		message.setData("");
		return new ResponseEntity<Message>(message, HttpStatus.CREATED);
	}
}
