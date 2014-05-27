package com.epam.task1.util;

import com.epam.task1.entity.coffee.Coffee;
import com.epam.task1.entity.coffee.CoffeeBeans;
import com.epam.task1.entity.coffee.CoffeeGround;
import com.epam.task1.entity.coffee.CoffeeInstant;
import com.epam.task1.entity.coffee.CoffeeOptions;
import com.epam.task1.entity.coffee.CoffeeType;

public class CoffeeBuilder
{
	public Coffee createCoffee( CoffeeType coffeeType )
	{
		if (CoffeeType.BEANS.equals(coffeeType))
		{
			return createCoffeeBeans();
		} else if (CoffeeType.GROUND.equals(coffeeType))
		{
			return createGroundCoffee();
		} else if (CoffeeType.INSTANT.equals(coffeeType))
		{
			return createInstantCoffee();
		} else
		{
			return null;
		}
	}

	private CoffeeBeans createCoffeeBeans()
	{
		return generateCoffeeBeans();
	}

	private CoffeeGround createGroundCoffee()
	{
		return new CoffeeGround(generateCoffeeBeans(),
								CoffeeOptions.getRandomCoffeeGrind());
	}

	private CoffeeInstant createInstantCoffee()
	{
		return new CoffeeInstant(generateCoffeeBeans(),
								CoffeeOptions.getRandomInstantCoffeeType());
	}
	
	private CoffeeBeans generateCoffeeBeans()
	{
		return new CoffeeBeans(CoffeeOptions.getRandomCoffeeKind(),
				CoffeeOptions.getRandomOrigin(),
				CoffeeOptions.getRandomCoffeeRoast(),
				CoffeeOptions.getRandomManufacturer());
	}
}
