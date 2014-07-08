package com.epam.task5.dao;

import com.epam.task5.exception.ProjectException;

public class XMLDaoException extends ProjectException{

	public XMLDaoException( String message ) {
		super( message );
	}

	public XMLDaoException( String message, Exception exception ) {
		super( message, exception );
	}

}
