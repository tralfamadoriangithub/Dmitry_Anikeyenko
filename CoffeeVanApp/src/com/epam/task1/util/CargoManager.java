package com.epam.task1.util;

import java.util.ArrayList;
import java.util.Collections;

import com.epam.task1.entity.coffee.Coffee;
import com.epam.task1.entity.pack.CoffeePack;

public class CargoManager
{
	public void sortCoffeePacks(ArrayList<CoffeePack<Coffee>> cargo)
	{
		Collections.sort(cargo);
	}
}
