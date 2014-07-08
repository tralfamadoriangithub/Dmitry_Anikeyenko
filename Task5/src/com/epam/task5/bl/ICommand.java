package com.epam.task5.bl;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
	public String execute(HttpServletRequest request) throws CommandException;
}
