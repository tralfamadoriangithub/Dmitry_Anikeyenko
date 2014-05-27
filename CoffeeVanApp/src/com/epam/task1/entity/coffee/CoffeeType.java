package com.epam.task1.entity.coffee;

import java.util.Random;


public enum CoffeeType
{
	BEANS, GROUND, INSTANT;
	
	public static CoffeeType getRandomCoffeeType()
	{
		CoffeeType[] coffeeType = CoffeeType.values();
		return coffeeType[new Random().nextInt(coffeeType.length)];
	}
}
