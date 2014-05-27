package com.epam.task1.entity.coffee;

import com.epam.task1.entity.coffee.CoffeeOptions.InstantCoffeeType;



public class CoffeeInstant extends CoffeeBeans
{
		private InstantCoffeeType instantCoffeeType;
		
		public CoffeeInstant(){}

		public CoffeeInstant( CoffeeBeans beans, InstantCoffeeType instantCoffeeType )
		{
			super( beans );
			setInstantCoffeeType( instantCoffeeType );
		}
		
		public CoffeeInstant( CoffeeInstant coffeeInstant )
		{
			this(coffeeInstant.getCoffeeBeans(), coffeeInstant.getInstantCoffeeType());
		}
		
		

		public InstantCoffeeType getInstantCoffeeType()
		{
			return instantCoffeeType;
		}

		public void setInstantCoffeeType(
				InstantCoffeeType instantCoffeeType )
		{
			this.instantCoffeeType = instantCoffeeType;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = super.hashCode();
			result = prime
					* result
					+ ((instantCoffeeType == null) ? 0 : instantCoffeeType
							.hashCode());
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
			CoffeeInstant other = (CoffeeInstant) obj;
			if (instantCoffeeType != other.instantCoffeeType)
				return false;
			return true;
		}

		@Override
		public String toString()
		{
			return "CoffeeInstant Type=" + instantCoffeeType.getValue() + "; "
					+ super.toString();
		}
		
		
}
