package com.epam.task4.entity;

import javax.xml.bind.annotation.*;

@XmlRootElement( name = "plane" )
public class Plane {

	private String model;
	private String nrName;
	private String origin;
	private String planeType;
	private int crew;
	private int armament;
	private String radad;
	private double length;
	private double height;
	private double width;
	private double price;

	public String getModel() {
		return model;
	}
	
	public void setModel( String model ) {
		this.model = model;
	}
	@XmlAttribute
	public String getNrName() {
		return nrName;
	}

	public void setNrName( String nrName ) {
		this.nrName = nrName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin( String origin ) {
		this.origin = origin;
	}
	@XmlElement(name = "type")
	public String getPlaneType() {
		return planeType;
	}

	public void setPlaneType( String planeType ) {
		this.planeType = planeType;
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

	public String getRadad() {
		return radad;
	}

	public void setRadad( String radad ) {
		this.radad = radad;
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

	public double getPrice() {
		return price;
	}

	public void setPrice( double price ) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + armament;
		result = prime * result + crew;
		long temp;
		temp = Double.doubleToLongBits( height );
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits( length );
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		result = prime * result
				+ ((planeType == null) ? 0 : planeType.hashCode());
		temp = Double.doubleToLongBits( price );
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((radad == null) ? 0 : radad.hashCode());
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
		if ( origin == null ) {
			if ( other.origin != null )
				return false;
		} else if ( !origin.equals( other.origin ) )
			return false;
		if ( planeType != other.planeType )
			return false;
		if ( Double.doubleToLongBits( price ) != Double
				.doubleToLongBits( other.price ) )
			return false;
		if ( radad == null ) {
			if ( other.radad != null )
				return false;
		} else if ( !radad.equals( other.radad ) )
			return false;
		if ( Double.doubleToLongBits( width ) != Double
				.doubleToLongBits( other.width ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [model=" + model + ", origin="
				+ origin + ", planeType=" + planeType + ", crew=" + crew
				+ ", armament=" + armament + ", radad=" + radad + ", length="
				+ length + ", height=" + height + ", width=" + width
				+ ", price=" + price + "]";
	}

}
