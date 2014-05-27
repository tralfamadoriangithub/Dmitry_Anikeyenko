package com.epam.task1.entity.pack;

import java.util.Random;

public enum PackSize
{
	SMALL(5,12,4, 100), MEDIUM(7,15,6, 250), LARGE(10,20,8, 500);
	
	private double width;
	private double height; 
	private double length;
	private double weight;
	
	private PackSize(double w, double h, double l, double wg){
		width = w;
		height = h;
		length = l;
		weight = wg;
	}
	
	public double getWidth()
	{
		return width;
	}

	public double getHeight()
	{
		return height;
	}

	public double getLength()
	{
		return length;
	}
	
	public double getWeight()
	{
		return weight;
	}

	public static PackSize getRandomSize()
	{
		PackSize[] size = values();
		return size[new Random().nextInt(size.length)];
	}
	
}
