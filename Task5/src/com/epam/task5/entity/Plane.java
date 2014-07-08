package com.epam.task5.entity;

public class Plane {

	private String nrName;
	private String model;
	private String origin;
	private double price;
	private double length;
	private double height;
	private double width;
	private String type;
	private int crew;
	private int armament;
	private String hasRadar;

	public String getNrName() {
		return nrName;
	}

	public void setNrName( String nrName ) {
		this.nrName = nrName;
	}

	public String getModel() {
		return model;
	}

	public void setModel( String model ) {
		this.model = model;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin( String origin ) {
		this.origin = origin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice( double price ) {
		this.price = price;
	}

	public double getLength() {
		return length;
	}

	public void setLength( double length ) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight( double height ) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth( double width ) {
		this.width = width;
	}

	public String getType() {
		return type;
	}

	public void setType( String type ) {
		this.type = type;
	}

	public int getCrew() {
		return crew;
	}

	public void setCrew( int crew ) {
		this.crew = crew;
	}

	public int getArmament() {
		return armament;
	}

	public void setArmament( int armament ) {
		this.armament = armament;
	}

	public String isHasRadar() {
		return hasRadar;
	}

	public void setHasRadar( String hasRadar ) {
		this.hasRadar = hasRadar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + armament;
		result = prime * result + crew;
		result = prime * result
				+ ((hasRadar == null) ? 0 : hasRadar.hashCode());
		long temp;
		temp = Double.doubleToLongBits( height );
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits( length );
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((nrName == null) ? 0 : nrName.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		temp = Double.doubleToLongBits( price );
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		temp = Double.doubleToLongBits( width );
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		Plane other = (Plane) obj;
		if ( armament != other.armament )
			return false;
		if ( crew != other.crew )
			return false;
		if ( hasRadar == null ) {
			if ( other.hasRadar != null )
				return false;
		} else if ( !hasRadar.equals( other.hasRadar ) )
			return false;
		if ( Double.doubleToLongBits( height ) != Double
				.doubleToLongBits( other.height ) )
			return false;
		if ( Double.doubleToLongBits( length ) != Double
				.doubleToLongBits( other.length ) )
			return false;
		if ( model == null ) {
			if ( other.model != null )
				return false;
		} else if ( !model.equals( other.model ) )
			return false;
		if ( nrName == null ) {
			if ( other.nrName != null )
				return false;
		} else if ( !nrName.equals( other.nrName ) )
			return false;
		if ( origin == null ) {
			if ( other.origin != null )
				return false;
		} else if ( !origin.equals( other.origin ) )
			return false;
		if ( Double.doubleToLongBits( price ) != Double
				.doubleToLongBits( other.price ) )
			return false;
		if ( type == null ) {
			if ( other.type != null )
				return false;
		} else if ( !type.equals( other.type ) )
			return false;
		if ( Double.doubleToLongBits( width ) != Double
				.doubleToLongBits( other.width ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [nrName=" + nrName + ", model="
				+ model + ", origin=" + origin + ", price=" + price
				+ ", length=" + length + ", height=" + height + ", width="
				+ width + ", type=" + type + ", crew=" + crew + ", armament="
				+ armament + ", hasRadar=" + hasRadar + "]";
	}

}
