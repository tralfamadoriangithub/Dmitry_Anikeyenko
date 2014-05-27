package com.epam.task1.entity.coffee;

import com.epam.task1.entity.coffee.CoffeeOptions.CoffeeKind;
import com.epam.task1.entity.coffee.CoffeeOptions.CoffeeOrigin;

public abstract class Coffee
{
	private CoffeeKind coffeeKind;
	private CoffeeOrigin coffeeOrigin;
	
	public Coffee(){}

	public Coffee( CoffeeKind coffeeKind, CoffeeOrigin coffeeOrigin )
	{
		setKind( coffeeKind );
		setCoffeeOrigin(coffeeOrigin);
	}
	
	public Coffee getCoffee()
	{
		return this;
	}

	public CoffeeKind getCoffeeKind()
	{
		return coffeeKind;
	}

	public void setKind( CoffeeOptions.CoffeeKind kind )
	{
		this.coffeeKind = kind;
	}

	public CoffeeOrigin getCoffeeOrigin()
	{
		return coffeeOrigin;
	}

	public void setCoffeeOrigin( CoffeeOrigin coffeeOrigin )
	{
		this.coffeeOrigin = coffeeOrigin;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coffeeKind == null) ? 0 : coffeeKind.hashCode());
		result = prime * result
				+ ((coffeeOrigin == null) ? 0 : coffeeOrigin.hashCode());
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
		Coffee other = (Coffee) obj;
		if (coffeeKind != other.coffeeKind)
			return false;
		if (coffeeOrigin != other.coffeeOrigin)
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Kind=" + coffeeKind.getValue() + ", Origin=" + coffeeOrigin.getValue();
	}
	
	

}
