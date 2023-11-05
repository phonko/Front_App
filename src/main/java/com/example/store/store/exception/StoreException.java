package com.example.store.store.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.store.exception.BaseException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class StoreException extends BaseException{
	
	private static final long serialVersionUID = 1L;
	
	public StoreException(String code, HttpStatus status) { 
		super("student." + code, status);
	}
	public static StoreException emptyStudent() {
		return new StoreException("findStudent.notFound", HttpStatus.BAD_REQUEST);
	}
}
