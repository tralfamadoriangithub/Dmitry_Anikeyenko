package com.epam.task4.entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanesList {

	@XmlElement( name = "plane" )
	private ArrayList<Plane> list;
	private String planesListName;
	
	public PlanesList(){
		list = new ArrayList<>();
	}

	public ArrayList<Plane> getList() {
		return list;
	}

	public void setList( ArrayList<Plane> list ) {
		this.list = list;
	}

	public String getPlanesListName() {
		return planesListName;
	}

	public void setPlanesListName( String planesListName ) {
		this.planesListName = planesListName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result
				+ ((planesListName == null) ? 0 : planesListName.hashCode());
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
		PlanesList other = (PlanesList) obj;
		if ( list == null ) {
			if ( other.list != null )
				return false;
		} else if ( !list.equals( other.list ) )
			return false;
		if ( planesListName == null ) {
			if ( other.planesListName != null )
				return false;
		} else if ( !planesListName.equals( other.planesListName ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [list=" + list + ", planesListName="
				+ planesListName + "]";
	}
	
	

}
