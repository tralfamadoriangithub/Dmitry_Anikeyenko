package com.epam.task3.entity;

import java.util.concurrent.TimeUnit;

public class Train implements Runnable{

	private String trainName;
	private Route trainRoute;

	public Train() {

	}

	public Train( String trainName, Route trainRoute ) {
		setTrainName( trainName );
		setTrainRoute( trainRoute );
	}
	
	public void run(){
		try {
			TimeUnit.SECONDS.sleep( 5 );
			System.out.println("Train " + getTrainName() + " passed, route " + getTrainRoute());
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName( String trainName ) {
		this.trainName = trainName;
	}

	public Route getTrainRoute() {
		return trainRoute;
	}

	public void setTrainRoute( Route trainRoute ) {
		this.trainRoute = trainRoute;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [trainName=" + trainName
				+ ", trainRoute=" + trainRoute + "]";
	}

}
