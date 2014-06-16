package com.epam.task4.main;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.epam.task4.entity.Plane;
import com.epam.task4.entity.PlanesList;

public class Main {

	public static void main( String[] args ) throws JAXBException {
		
		ArrayList<Plane> planes = new ArrayList<>();
		
		Plane plane1 = new Plane();
		plane1.setModel( "MiG-29" );
		plane1.setNrName( "Fulcrum" );
		plane1.setOrigin( "Russia" );
		plane1.setPlaneType( "fighter" );
		plane1.setCrew( 2 );
		plane1.setArmament( 7 );
		plane1.setRadad( "yes" );
		plane1.setPrice( 30 );
		plane1.setLength( 17.32 );
		plane1.setWidth( 11.36 );
		plane1.setHeight( 4.73 );
		
		planes.add( plane1 );
		
		PlanesList planesList = new PlanesList();
		planesList.setList( planes );
		
		JAXBContext jaxbContext = JAXBContext.newInstance( PlanesList.class );
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		marshaller.marshal( planesList, new File("output.xml") );
	}

}
