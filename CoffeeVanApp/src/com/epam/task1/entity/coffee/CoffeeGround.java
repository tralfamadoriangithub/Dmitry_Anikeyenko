package com.epam.task1.entity.coffee;

import com.epam.task1.entity.coffee.CoffeeOptions.CoffeeGrind;


public class CoffeeGround extends CoffeeBeans
{
		private CoffeeGrind coffeeGrind;
		
		public CoffeeGround()
		{
		}

		public CoffeeGround( CoffeeBeans beans, CoffeeGrind grind )
		{
			super( beans );
			setCoffeeGrind( grind );
		}
		
		public CoffeeGround( CoffeeGround coffeeGround )
		{
			this( coffeeGround.getCoffeeBeans(), coffeeGround.getCoffeeGrind());
		}

		public CoffeeGrind getCoffeeGrind()
		{
			return coffeeGrind;
		}

		public void setCoffeeGrind( CoffeeGrind grind )
		{
			this.coffeeGrind = grind;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((coffeeGrind == null) ? 0 : coffeeGrind.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			CoffeeGround other = (CoffeeGround) obj;
			if (coffeeGrind != other.coffeeGrind)
				return false;
			return true;
		}

		@Override
		public String toString()
		{
			return "CoffeeGround Grind=" + coffeeGrind.getValue() + "; " + super.toString();
		}	
}
