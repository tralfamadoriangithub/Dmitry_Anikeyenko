package com.epam.task5.dao;

import java.util.List;

import com.epam.task5.entity.Plane;

public interface XMLDao {
	public List<Plane> parse ( String resourceName ) throws XMLDaoException;
}
