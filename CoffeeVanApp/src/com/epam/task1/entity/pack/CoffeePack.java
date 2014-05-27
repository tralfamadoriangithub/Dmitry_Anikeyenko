package com.epam.task1.entity.pack;

import com.epam.task1.entity.coffee.Coffee;

public class CoffeePack < T extends Coffee > extends Pack implements Comparable< CoffeePack <?> >
{
		private double price;
		private double weight;
		private T coffee;
		
		public CoffeePack(){}
		
		public CoffeePack(double width, double height, double length, T coffee){
			
		}
	
		public CoffeePack(T coffee, double weight){
			
		}
		
		public CoffeePack( Pack pack, T coffee, double weight, double price )
		{
			super( pack );
			setCoffee( coffee );
			setWeight( weight );
			setPrice( price );
		}
		
		public double getPrice()
		{
			return price;
		}
		
		public void setPrice( double price )
		{
			this.price = price;
		}
		
		public T getCoffee()
		{
			return coffee;
		}
		
		public void setCoffee( T coffee )
		{
			this.coffee = coffee;
		}
		
		public void setWeight( double weight )
		{
			this.weight = weight;
		}
		
		public double getWeight()
		{
			return weight;
		}

		@Override
		public int compareTo(CoffeePack <?> o)
		{
			return Double.valueOf(getPrice()/getWeight()).compareTo(Double.valueOf(o.getPrice()/o.getWeight()));
		}
		
		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result
					+ ((coffee == null) ? 0 : coffee.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(weight);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals( Object obj )
		{
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			CoffeePack other = (CoffeePack) obj;
			if (coffee == null)
			{
				if (other.coffee != null)
					return false;
			} else if (!coffee.equals(other.coffee))
				return false;
			if (Double.doubleToLongBits(price) != Double
					.doubleToLongBits(other.price))
				return false;
			if (Double.doubleToLongBits(weight) != Double
					.doubleToLongBits(other.weight))
				return false;
			return true;
		}

		@Override
		public String toString()
		{
			return "CoffeePack Price=" + price + ", Weight=" + weight + ", "
					+ super.toString() + "; Coffee : " + coffee;
		}
		
		

}
