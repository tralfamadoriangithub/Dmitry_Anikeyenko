package com.epam.task5.exception;

public class ProjectException extends Exception{
	private Exception hiddenException;
	
	public ProjectException(String message){
		super(message);
	}
	
	public ProjectException(String message, Exception exception){
		super(message);
		hiddenException = exception;
	}
	
	public Exception getHiddenException(){
		return hiddenException;
	}
}