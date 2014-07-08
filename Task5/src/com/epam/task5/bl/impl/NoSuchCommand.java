package com.epam.task5.bl.impl;

import javax.servlet.http.HttpServletRequest;

import com.epam.task5.bl.CommandException;
import com.epam.task5.bl.ICommand;
import com.epam.task5.controller.JspPageName;

public class NoSuchCommand implements ICommand{

	@Override
	public String execute( HttpServletRequest request ) throws CommandException {
		return JspPageName.ERROR_PAGE;
	}

}
