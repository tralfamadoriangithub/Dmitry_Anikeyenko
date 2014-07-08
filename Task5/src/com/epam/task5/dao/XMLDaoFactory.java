package com.epam.task5.dao;

import com.epam.task5.dao.impl.DomXMLDao;
import com.epam.task5.dao.impl.SaxXMLDao;
import com.epam.task5.dao.impl.StaxXMLDao;

public class XMLDaoFactory {
	private static final XMLDaoFactory instance;
	
	static{
		instance = new XMLDaoFactory();
	}
	
	public static XMLDaoFactory getInstance(){
		return instance;
	}
	
	public XMLDao getDao(String daoType){
		
		switch ( DaoType.valueOf(daoType.toUpperCase())) {
		case SAX:
			return SaxXMLDao.getInstance();
		
		case STAX:
			return StaxXMLDao.getInstance();
			
		case DOM:
			return DomXMLDao.getInstance();
		default:
			break;
		}
		return null;
	}
	
	public enum DaoType{
		SAX, STAX, DOM
	}
}
