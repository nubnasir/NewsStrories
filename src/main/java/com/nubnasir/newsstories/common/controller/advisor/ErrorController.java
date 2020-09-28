package com.nubnasir.newsstories.common.controller.advisor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public String handleDataNotFound(HttpServletRequest request, EmptyResultDataAccessException e) {
		return "404";
	}

	@ExceptionHandler(Exception.class)
	public String handleException(Exception exception) {
		exception.printStackTrace();
		return "system-error";
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleError404(HttpServletRequest request, Exception e) {
		return "404";
	}

}
