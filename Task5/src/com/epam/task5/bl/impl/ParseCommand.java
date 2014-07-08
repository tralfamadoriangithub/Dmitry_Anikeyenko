package com.epam.task5.bl.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.epam.task5.bl.CommandException;
import com.epam.task5.bl.ICommand;
import com.epam.task5.controller.JspPageName;
import com.epam.task5.controller.RequestParameterName;
import com.epam.task5.dao.XMLDao;
import com.epam.task5.dao.XMLDaoException;
import com.epam.task5.dao.XMLDaoFactory;
import com.epam.task5.entity.Plane;

public class ParseCommand implements ICommand{

	@Override
	public String execute( HttpServletRequest request ) throws CommandException {

		String page = null;
		XMLDao dao = null;
		
		try {
			dao = XMLDaoFactory.getInstance().getDao( request.getParameter( RequestParameterName.PARSER ) );
			List<Plane> info = dao.parse( request.getParameter( RequestParameterName.FILE_NAME ) );
			request.setAttribute( RequestParameterName.SIMPLE_INFO, info );
			page = JspPageName.USER_PAGE;
		} catch ( XMLDaoException e ) {
			throw new CommandException( "Can't get DAO" );
		}
		return page;
	}

}
