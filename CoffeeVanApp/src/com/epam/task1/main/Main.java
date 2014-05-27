package com.epam.task1.main;

import com.epam.task1.util.CargoManager;
import com.epam.task1.util.VanLoader;
import com.epam.task1.van.Van;

public class Main
{
	public static void main( String[] args )
	{
		Van van = new Van( 23238 );
		VanLoader vanLoader = new VanLoader();
		vanLoader.loadVan( van, 7000 );
		CargoManager cargoManager = new CargoManager();
		cargoManager.sortCoffeePacks( van.getCargo() );
		van.getCargo().forEach( System.out::println );
	}

}
