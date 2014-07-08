package com.epam.task5.bl;

import com.epam.task5.exception.ProjectException;

public class CommandException extends ProjectException{

	private static final long serialVersionUID = 1L;

	public CommandException( String message ) {
		super( message );
	}

	public CommandException( String message, Exception exception ) {
		super( message, exception );
	}
}
