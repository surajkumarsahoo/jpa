package com.mindtree.showmanagement.exceptionhandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.showmanagement.controller.ShowManagementController;
import com.mindtree.showmanagement.exceptions.controllerexception.ShowManagementControllerException;

@RestControllerAdvice(assignableTypes = {ShowManagementController.class})
public class ShowMangementExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<Map<String,Object>> exceptionHandler(ShowManagementControllerException c,Throwable cause){
		
		Map<String,Object> error = new HashMap<String, Object>();
		error.put("Message", "Error message");
		error.put("Body",c.getMessage());
		error.put("HttpStatus",HttpStatus.BAD_REQUEST);
		error.put("error",true);
		return new ResponseEntity<Map<String,Object>>(error, HttpStatus.NOT_FOUND);
	}

}
