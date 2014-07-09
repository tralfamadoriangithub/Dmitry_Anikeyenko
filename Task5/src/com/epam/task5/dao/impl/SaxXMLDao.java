package com.epam.task5.dao.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.task5.dao.XMLDao;
import com.epam.task5.dao.XMLDaoException;
import com.epam.task5.entity.Plane;

public class SaxXMLDao implements XMLDao {

	private final static SaxXMLDao instance;

	static {
		instance = new SaxXMLDao();
	}

	public static XMLDao getInstance() {
		return instance;
	}

	@Override
	public List<Plane> parse( String resourceName ) throws XMLDaoException {

		List<Plane> list = null;
		try {
			list = new SaxParser().getListFromFile( resourceName );
		} catch ( ParserConfigurationException | SAXException | IOException e ) {
			new XMLDaoException( "SAXParser exception", e);
		}
		
		return list;
	}

	private class SaxParser {

		private List<Plane> planesList;

		private List<Plane> getListFromFile( String resourceName ) throws ParserConfigurationException, SAXException, IOException {
			planesList = new ArrayList<>();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			SaxHandler handler = new SaxHandler();
			parser.parse( new File( resourceName ), handler );
			return planesList;
		}

		private class SaxHandler extends DefaultHandler {

			Plane plane;
			String tagContent = "";

			@Override
			public void startElement( String uri, String localName,
					String qName, Attributes attributes ) throws SAXException {
				if ( "plane".equals( qName ) ) {
					plane = new Plane();
					plane.setNrName( attributes.getValue( "nrName" ) );
				}
			}

			@Override
			public void endElement( String uri, String localName, String qName )
					throws SAXException {
				switch ( qName ) {
				case "plane":
					planesList.add( plane );
					break;
				case "model":
					plane.setModel( tagContent );
					break;
				case "origin":
					plane.setOrigin( tagContent );
					break;
				case "type":
					plane.setType( tagContent );
					break;
				case "crew":
					plane.setCrew( Integer.valueOf( tagContent ) );
					break;
				case "radar":
					plane.setHasRadar( tagContent );
					break;
				case "length":
					plane.setLength( Double.valueOf( tagContent ) );
					break;
				case "height":
					plane.setHeight( Double.valueOf( tagContent ) );
					break;
				case "width":
					plane.setWidth( Double.valueOf( tagContent ) );
					break;
				case "price":
					plane.setPrice( Double.valueOf( tagContent ) );
					break;

				default:
					break;
				}
			}

			@Override
			public void characters( char[] ch, int start, int length )
					throws SAXException {
				tagContent = new String( ch, start, length );
			}
		}
	}

}
