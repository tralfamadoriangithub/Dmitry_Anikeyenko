package com.epam.task3.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.epam.task3.entity.Tonnel;
import com.epam.task3.entity.Train;

public class RailwayDispatcher {

	private Map<Tonnel, TonnelManager> managers;
	private static RailwayDispatcher railwayDispatcher;

	private RailwayDispatcher() {
		managers = new HashMap<>();
	}

	public static RailwayDispatcher createInstance() {

		if ( railwayDispatcher == null ) {
			railwayDispatcher = new RailwayDispatcher();
		}
		return railwayDispatcher;
	}

	public void addNewTonnel( Tonnel... tonnels ) {

		TonnelManager tonnelManager;
		for ( Tonnel tonnel : tonnels ) {
			tonnelManager = new TonnelManager( tonnel );
			managers.put( tonnel, tonnelManager );
			tonnelManager.start();
		}
	}

	public void addNewTrain( Train newTrain, Tonnel tonnel ) {

		if ( managers.containsKey( tonnel ) ) {
			managers.get( tonnel ).setTrainToList( newTrain );
		}

	}

	public void joinDispatcher() {

		managers.forEach( ( tonnel, tonnelManager ) -> {
			try {
				tonnelManager.join();
			} catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		} );

	}

	private class TonnelManager extends Thread {

		private Tonnel tonnel;
		private LinkedList<Train> trainsList;
		private Train[] trainsInTonnel;
		private volatile boolean run = true;
		private Executor executor;

		private TonnelManager( Tonnel tonnel ) {

			this.tonnel = tonnel;
			trainsInTonnel = new Train[tonnel.getMaxTrainsInTonnel()];
			trainsList = new LinkedList<>();
			executor = Executors.newFixedThreadPool( tonnel
					.getMaxTrainsInTonnel() );

		}

		@Override
		public void run() {
			while ( run ) {
				passTrain( getTrainFromList() );
			}
		}

		private Train getTrainFromList() {

			Train train;
			synchronized ( trainsList ) {

				train = trainsList.poll();
				while ( train == null ) {
					try {
						trainsList.wait();
					} catch ( InterruptedException e ) {
						e.printStackTrace();
					}
					train = trainsList.poll();
				}
			}
			return train;

		}

		private void setTrainToList( Train newTrain ) {
			System.out.println( "Train " + newTrain.getTrainName()
					+ " came to " + tonnel.getTonnelName() + " tonnel. Route "
					+ newTrain.getTrainRoute() );
			synchronized ( trainsList ) {
				trainsList.add( newTrain );
				trainsList.notify();

			}
		}

		private void passTrain( Train train ) {
			executor.execute( new Passer( train ) );
		}

		private class Passer implements Runnable {

			Train train;

			private Passer( Train train ) {
				this.train = train;
			}

			@Override
			public void run() {
				try {
					System.out.println( "Train " + train.getTrainName()
							+ " in " + tonnel.getTonnelName()
							+ " tonnel, route " + train.getTrainRoute() );
					TimeUnit.SECONDS.sleep( 5 );
					System.out.println( "Train " + train.getTrainName()
							+ " passed " + tonnel.getTonnelName()
							+ " tonnel, route " + train.getTrainRoute() );
				} catch ( InterruptedException e ) {
					e.printStackTrace();
				}
			}
		}
	}
}
