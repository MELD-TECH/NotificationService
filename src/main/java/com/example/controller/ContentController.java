package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.component.ContentMail;
import com.example.service.DispatchMailService;

import jakarta.mail.MessagingException;

@RestController
public class ContentController {

	@Autowired
	private DispatchMailService service;
	
	@PostMapping("/send")
	public ResponseEntity<Object> sendmail(@RequestBody ContentMail request) throws MessagingException{
		
		service.sendMail(request);
		
		return new ResponseEntity<Object>("Mail send successfully", HttpStatus.OK);
	}
	
	@PostMapping("/attach")
	public ResponseEntity<Object> sendmailAttachment(@RequestBody ContentMail request) throws MessagingException{
		
		service.sendMailWithAttachment(request);
		
		return new ResponseEntity<Object>("Mail send successfully", HttpStatus.OK);
	}
}
