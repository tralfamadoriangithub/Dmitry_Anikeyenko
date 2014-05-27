package com.epam.task1.entity.pack;

//import com.epam.task1.entity.pack.PackMaterial;

public class Pack
{
	private double width;
	private double height;
	private double length;
	private double volume;
	private PackMaterial packMaterial;
	private PackSize packSize;

	public Pack()
	{
	}

	public Pack( PackMaterial packMaterial, PackSize packSize )
	{
		setPackMaterial(packMaterial);
		this.packSize = packSize;
		setPackSize(packSize);
		setHeight(packSize.getHeight());
		setLength(packSize.getLength());
		setWidth(packSize.getWidth());
	}

	public Pack( PackMaterial packMaterial, double width, double height,
			double length )
	{
		setWidth(width);
		setHeight(height);
		setLength(length);
		setVolume(width * length * height);
		setPackMaterial(packMaterial);
	}

	
	 public Pack ( Pack pack )
	 {
	 this(pack.getPackMaterial(), pack.getWidth(), pack.getHeight(), pack.getLength());
	 }

	public Pack getPack()
	{
		return this;
	}

	public double getWidth()
	{
		return width;
	}

	public void setWidth( double width )
	{
		this.width = width;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight( double height )
	{
		this.height = height;
	}

	public double getLength()
	{
		return length;
	}

	public void setLength( double length )
	{
		this.length = length;
	}

	public double getVolume()
	{
		if(volume == 0)
		{
			volume = width*length*height;
		}
		return volume;
	}

	public void setVolume( double volume )
	{
		this.volume = volume;
	}

	public PackMaterial getPackMaterial()
	{
		return packMaterial;
	}

	public void setPackMaterial( PackMaterial packMaterial )
	{
		this.packMaterial = packMaterial;
	}

	public PackSize getPackSize()
	{
		return packSize;
	}

	public void setPackSize( PackSize packSize )
	{
		this.packSize = packSize;
	}
	
	

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((packMaterial == null) ? 0 : packMaterial.hashCode());
		result = prime * result
				+ ((packSize == null) ? 0 : packSize.hashCode());
		temp = Double.doubleToLongBits(volume);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
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
		Pack other = (Pack) obj;
		if (Double.doubleToLongBits(height) != Double
				.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(length) != Double
				.doubleToLongBits(other.length))
			return false;
		if (packMaterial != other.packMaterial)
			return false;
		if (packSize != other.packSize)
			return false;
		if (Double.doubleToLongBits(volume) != Double
				.doubleToLongBits(other.volume))
			return false;
		if (Double.doubleToLongBits(width) != Double
				.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Volume=" + getVolume() + ", PackMaterial=" + packMaterial.getValue();
	}

}
