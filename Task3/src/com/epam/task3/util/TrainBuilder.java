package com.epam.task3.util;

import java.util.Random;

import com.epam.task3.entity.Route;
import com.epam.task3.entity.Train;

public class TrainBuilder {
	
	static Random random;
	
	static{
		random = new Random();
	}

	public static Train buildRandomTrain() {
		return new Train( getRandomName(), getRandomRoute() );
	}

	private static Route getRandomRoute() {
		
		Route[] routes = Route.values();
		return routes[random.nextInt( routes.length )];
	}
	
	private static String getRandomName() {
		return String.valueOf( random.nextInt( 1024 ) );
	}

}
