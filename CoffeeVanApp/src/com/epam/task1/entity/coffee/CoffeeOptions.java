package com.epam.task1.entity.coffee;

import java.util.Random;

public class CoffeeOptions
{
	private static Random rnd;

	public static enum CoffeeKind
	{
		ARABICA( "Arabica" ), ROBUSTA( "Robusta" );

		private String value;

		CoffeeKind( String v )
		{
			value = v;
		}

		public String getValue()
		{
			return value;
		}
	}

	public static enum CoffeeRoast
	{
		UNROASTED( "Unroasted" ), LIGHT( "Light" ), MEDIUM( "Medium" ), DARK(
				"Dark" );

		private String value;

		CoffeeRoast( String v )
		{
			value = v;
		}

		public String getValue()
		{
			return value;
		}
	}

	public static enum CoffeeGrind
	{
		COARSE( "Coarse" ), AVERAGE( "Average" ), FINE( "Fine" ), SUPERFINE(
				"Superfine" );

		private String value;

		CoffeeGrind( String v )
		{
			value = v;
		}

		public String getValue()
		{
			return value;
		}
	}

	public static enum InstantCoffeeType
	{
		POWDER( "Powder" ), GRANULAR( "Granulag" ), FREEZE_DRIED(
				"Freeze - dried" );

		private String value;

		private InstantCoffeeType( String v )
		{
			value = v;
		}

		public String getValue()
		{
			return value;
		}
	}

	public static enum CoffeeManufacturer
	{
		JACOBS( "Jacobs" ), TCHIBO( "Tchibo" ), NESCAFE( "Nescafe" );

		private String value;

		private CoffeeManufacturer( String v )
		{
			value = v;
		}

		public String getValue()
		{
			return value;
		}
	}
	
	public static enum CoffeeOrigin
	{
		BRAZIL( "Brazil" ), VENEZUELA( "Venezuela" ), BOLIVIA( "Bolivia" );

		private String value;

		private CoffeeOrigin( String v )
		{
			value = v;
		}

		public String getValue()
		{
			return value;
		}
	}

	static
	{
		rnd = new Random();
	}

	public static CoffeeKind getRandomCoffeeKind()
	{
		CoffeeKind[] kinds = CoffeeKind.values();
		return kinds[rnd.nextInt(kinds.length)];
	}

	public static CoffeeRoast getRandomCoffeeRoast()
	{
		CoffeeRoast[] roast = CoffeeRoast.values();
		return roast[rnd.nextInt(roast.length)];
	}

	public static CoffeeGrind getRandomCoffeeGrind()
	{
		CoffeeGrind[] grind = CoffeeGrind.values();
		return grind[rnd.nextInt(grind.length)];
	}

	public static InstantCoffeeType getRandomInstantCoffeeType()
	{
		InstantCoffeeType[] instantCoffeeType = InstantCoffeeType.values();
		return instantCoffeeType[rnd.nextInt(instantCoffeeType.length)];
	}

	public static CoffeeManufacturer getRandomManufacturer()
	{
		CoffeeManufacturer[] manufacturer = CoffeeManufacturer.values();
		return manufacturer[rnd.nextInt(manufacturer.length)];
	}
	
	public static CoffeeOrigin getRandomOrigin()
	{
		CoffeeOrigin[] origin = CoffeeOrigin.values();
		return origin[rnd.nextInt(origin.length)];
	}
}
