package com.epam.task1.util;

import java.util.ArrayList;

import com.epam.task1.entity.coffee.Coffee;
import com.epam.task1.entity.coffee.CoffeeType;
import com.epam.task1.entity.pack.CoffeePack;
import com.epam.task1.entity.pack.PackMaterial;
import com.epam.task1.entity.pack.PackSize;
import com.epam.task1.van.Van;

public class VanLoader
{
	private double summ;
	private double loadedSpace;
	
	public void loadVan(Van van, double cash)
	{
		ArrayList<CoffeePack<Coffee>> cargo = van.getCargo();
		double totalSpace = van.getVolume();
		CoffeePackBuilder coffeePackBuilder = new CoffeePackBuilder();
		
		while(true)
		{
			CoffeePack coffeePack = coffeePackBuilder.createCoffeePack( PackSize.getRandomSize(),
					PackMaterial.getRandomMaterial(),
					CoffeeType.getRandomCoffeeType());
			summ += coffeePack.getPrice();
			loadedSpace += coffeePack.getVolume();
			if(summ > cash || loadedSpace > totalSpace)
			{
				van.setEmptyVolume(totalSpace - loadedSpace - coffeePack.getVolume());
				break;
			}
			cargo.add(coffeePack);
		}
		//cargo.forEach(System.out::println);
	}
}
