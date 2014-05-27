package com.epam.task1.entity.pack;

import java.util.Random;

public enum PackMaterial
{
	CARTON( "Carton" ), TIN_PLATE( "Tin-plate" ), WOOD( "Wood" ), FOIL_PACKAGE(
			"Foil package" );

	String value;

	PackMaterial( String v )
	{
		value = v;
	}

	public String getValue()
	{
		return value;
	}
	
	public static PackMaterial getRandomMaterial()
	{
		PackMaterial[] packMaterial = values();
		return packMaterial[new Random().nextInt(packMaterial.length)];
	}

}

