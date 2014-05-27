package com.epam.task1.util;

import java.text.DecimalFormat;

import com.epam.task1.entity.coffee.Coffee;
import com.epam.task1.entity.coffee.CoffeeType;
import com.epam.task1.entity.pack.CoffeePack;
import com.epam.task1.entity.pack.PackMaterial;
import com.epam.task1.entity.pack.PackSize;

public class CoffeePackBuilder
{
	private PackBuilder packBuilder;
	private CoffeeBuilder coffeeBuilder;
	
	public CoffeePackBuilder()
	{
		packBuilder = new PackBuilder();
		coffeeBuilder = new CoffeeBuilder();
	}

	public CoffeePack createCoffeePack(PackSize packSize, PackMaterial packMaterial, CoffeeType coffeeType)
	{
		return new CoffeePack<Coffee>(packBuilder.createPack( packMaterial, packSize ),
										coffeeBuilder.createCoffee(coffeeType),
										packSize.getWeight(), 
										Math.random()*20 + 5);
	}
}
