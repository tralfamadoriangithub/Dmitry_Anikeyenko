package com.epam.task3.entity;

public enum Route{
	EAST("East"), WEST("West")/*, NORTH("North"), SOUTH("South")*/;
	
	private String route;
	
	private Route(String r){
		route = r;
	}
	
	public String getRoute(){
		return route;
	}
}
