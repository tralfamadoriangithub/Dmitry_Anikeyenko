package com.epam.task1.entity.coffee;

import com.epam.task1.entity.coffee.CoffeeOptions.CoffeeKind;
import com.epam.task1.entity.coffee.CoffeeOptions.CoffeeManufacturer;
import com.epam.task1.entity.coffee.CoffeeOptions.CoffeeOrigin;
import com.epam.task1.entity.coffee.CoffeeOptions.CoffeeRoast;

public class CoffeeBeans extends Coffee
{
	private CoffeeRoast coffeeRoast;
	private CoffeeManufacturer coffeeManufacturer;

	public CoffeeBeans()
	{
	}

	public CoffeeBeans( CoffeeKind coffeeKind, CoffeeOrigin coffeeOrigin,
			CoffeeRoast coffeeRoast, CoffeeManufacturer coffeeManufacturer )
	{
		super(coffeeKind, coffeeOrigin);
		setCoffeeRoast(coffeeRoast);
		setCoffeeManufacturer(coffeeManufacturer);
	}

	public CoffeeBeans( CoffeeBeans beans )
	{
		this(beans.getCoffeeKind(), beans. getCoffeeOrigin(), beans.getCoffeeRoast(), beans.getCoffeeManufacturer());
	}

	public CoffeeBeans getCoffeeBeans()
	{
		return this;
	}

	public CoffeeRoast getCoffeeRoast()
	{
		return coffeeRoast;
	}

	public void setCoffeeRoast( CoffeeRoast roast )
	{
		this.coffeeRoast = roast;
	}

	public CoffeeManufacturer getCoffeeManufacturer()
	{
		return coffeeManufacturer;
	}

	public void setCoffeeManufacturer( CoffeeManufacturer manufacturer )
	{
		this.coffeeManufacturer = manufacturer;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coffeeManufacturer == null) ? 0 : coffeeManufacturer.hashCode());
		result = prime * result + ((coffeeRoast == null) ? 0 : coffeeRoast.hashCode());
		return result;
	}

	@Override
	public boolean equals( Object obj )
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeBeans other = (CoffeeBeans) obj;
		if (coffeeManufacturer != other.coffeeManufacturer)
			return false;
		if (coffeeRoast != other.coffeeRoast)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "CoffeeBeans Roast=" + coffeeRoast.getValue() + ", Manufacturer="
				+ coffeeManufacturer.getValue() + ", " + super.toString();
	}

}
