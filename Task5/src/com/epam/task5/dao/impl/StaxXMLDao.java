package com.epam.task5.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.task5.dao.XMLDao;
import com.epam.task5.dao.XMLDaoException;
import com.epam.task5.entity.Plane;

public class StaxXMLDao implements XMLDao {

	private static final StaxXMLDao instance;

	static {
		instance = new StaxXMLDao();
	}

	public static XMLDao getInstance() {
		return instance;
	}

	@Override
	public List<Plane> parse( String resourceName ) throws XMLDaoException {

		List<Plane> list;
		try {
			list = new StaxParser().getListFromFile( resourceName );
		} catch ( XMLStreamException | FileNotFoundException e ) {
			throw new XMLDaoException( "XMLStream exception ", e );
		}

		return list;

	}

	private class StaxParser {

		private List<Plane> getListFromFile( String resourceName )
				throws XMLStreamException, FileNotFoundException {
			List<Plane> planesList = new ArrayList<>();
			Plane plane = null;
			String tagContent = "";
			XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
			XMLStreamReader reader = xmlInputFactory
					.createXMLStreamReader( new FileInputStream( new File( resourceName ) ) );

			String localName = "";
			while ( reader.hasNext() ) {
				int event = reader.next();

				switch ( event ) {

				case XMLStreamConstants.START_DOCUMENT:
					//planesList = new ArrayList<>();
					break;

				case XMLStreamConstants.START_ELEMENT:
					localName = reader.getLocalName();
					if ( "plane".equals( localName ) ) {
						plane = new Plane();
						plane.setNrName( reader.getAttributeValue( 0 ) );
					}
					break;

				case XMLStreamConstants.CHARACTERS:
					if ( !("chars".equals( localName ) || "parameters".equals( localName )) ) {
						tagContent = reader.getText();
					}
					break;

				case XMLStreamConstants.END_ELEMENT:

					switch ( reader.getLocalName() ) {
					case "plane":
						planesList.add( plane );
						break;
					case "model":
						plane.setModel( tagContent );
						break;
					case "origin":
						plane.setOrigin( tagContent );
						break;
					case "price":
						plane.setPrice( Double.valueOf( tagContent ) );
						break;
					case "type":
						plane.setType( tagContent );
						break;
						
					case "crew":
						plane.setCrew( Integer.valueOf( tagContent ) );
						break;
						
					case "armament":
						plane.setArmament( Integer.valueOf( tagContent ) );
						break;
						
					case "radar":
						plane.setHasRadar( tagContent );
						break;
						
					case "length":
						plane.setLength( Double.valueOf( tagContent ) );
						break;
						
					case "width":
						plane.setWidth( Double.valueOf( tagContent ) );
						break;
						
					case "height":
						plane.setHeight( Double.valueOf( tagContent ) );
						break;
					
					}
				
				default:
					break;
				}
			}

			return planesList;
		}
	}

}
