package com.epam.task1.van;

import java.util.ArrayList;

import com.epam.task1.entity.coffee.Coffee;
import com.epam.task1.entity.pack.CoffeePack;
import com.epam.task1.entity.pack.Pack;

public class Van 
{
	private double volume;
	private double emptyVolume;
	private ArrayList <CoffeePack<Coffee>> cargo;
	
	public Van(){};
	
	public Van ( double volume )
	{
		setVolume( volume );
		setEmptyVolume(volume);
		cargo = new ArrayList<>();
	}
	
	public double getVolume()
	{
		return volume;
	}
	public void setVolume( double volume )
	{
		this.volume = volume;
	}
	
	public double getEmptyVolume()
	{
		return emptyVolume;
	}

	public void setEmptyVolume( double emptyVolume )
	{
		this.emptyVolume = emptyVolume;
	}

	public ArrayList<CoffeePack<Coffee>> getCargo()
	{
		return cargo;
	}
	public void setCargo( ArrayList<CoffeePack<Coffee>> cargo )
	{
		this.cargo = cargo;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(emptyVolume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals( Object obj )
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Van other = (Van) obj;
		if (cargo == null)
		{
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (Double.doubleToLongBits(emptyVolume) != Double
				.doubleToLongBits(other.emptyVolume))
			return false;
		if (Double.doubleToLongBits(volume) != Double
				.doubleToLongBits(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Van [volume=" + volume + ", emptyVolume=" + emptyVolume
				+ ", cargo=" + cargo + "]";
	}
}
