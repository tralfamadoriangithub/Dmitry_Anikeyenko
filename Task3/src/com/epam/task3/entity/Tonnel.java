package com.epam.task3.entity;

public class Tonnel {
	
	private String tonnelName;
	private int maxTrainsInTonnel;
	
	public Tonnel(){
		
	}
	
	public Tonnel(String tonnelName, int maxTrainsInTonnel){
		setTonnelName( tonnelName );
		setMaxTrainsInTonnel( maxTrainsInTonnel );
	}

	public String getTonnelName() {
		return tonnelName;
	}

	public void setTonnelName( String tonnelName ) {
		this.tonnelName = tonnelName;
	}

	public int getMaxTrainsInTonnel() {
		return maxTrainsInTonnel;
	}

	public void setMaxTrainsInTonnel( int maxTrainsInTonnel ) {
		this.maxTrainsInTonnel = maxTrainsInTonnel;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [tonnelName=" + tonnelName +  ", maxTrainsInTonnel="
				+ maxTrainsInTonnel + "]";
	}

	
}
