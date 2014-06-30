package com.epam.task3.main;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.epam.task3.entity.Tonnel;
import com.epam.task3.entity.Train;
import com.epam.task3.util.RailwayDispatcher;
import com.epam.task3.util.TrainBuilder;

public class Main {

	public static void main( String[] args ) {

		Tonnel firstTonnel;
		Tonnel secondTonnel;
		Tonnel thirdTonnel;
		RailwayDispatcher dispatcher;

		firstTonnel = new Tonnel( "First", 2 );
		secondTonnel = new Tonnel( "Second", 3 );
		thirdTonnel = new Tonnel( "Third", 2 );

		dispatcher = RailwayDispatcher.createInstance();
		dispatcher.addNewTonnel( firstTonnel, secondTonnel );
		dispatcher.addNewTonnel( thirdTonnel );
		
		Train newTrain;
		Random random = new Random();
		for ( int i = 0; i < 10; i++) {

			newTrain = TrainBuilder.buildRandomTrain();

			switch ( random.nextInt( 3 ) ) {
//			case 0:
//				dispatcher.addNewTrain( newTrain, firstTonnel );
//				break;
//			case 1:
//				dispatcher.addNewTrain( newTrain, secondTonnel );
//				break;
//			case 2:
//				dispatcher.addNewTrain( newTrain, thirdTonnel );
//				break;

			default:
				dispatcher.addNewTrain( newTrain, firstTonnel );
				break;
			}
			try {
				TimeUnit.SECONDS.sleep( random.nextInt( 3 ) );
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		}
		dispatcher.joinDispatcher();
	}

}
