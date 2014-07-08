package com.epam.task5.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.task5.dao.XMLDao;
import com.epam.task5.dao.XMLDaoException;
import com.epam.task5.entity.Plane;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class DomXMLDao implements XMLDao {
	private static final DomXMLDao instance;

	static {
		instance = new DomXMLDao();
	}

	public static XMLDao getInstance() {
		return instance;
	}

	@Override
	public List<Plane> parse( String resourceName ) throws XMLDaoException {

		List<Plane> list;
		try {
			list = new DomParser().getListFromFile( resourceName );
		} catch ( SAXException | IOException | ParserConfigurationException e ) {
			throw new XMLDaoException( "Parser exception", e );
		}

		return list != null ? list : new ArrayList<>();

	}

	private final class DomParser {

		private List<Plane> getListFromFile( String resourceName )
				throws ParserConfigurationException, SAXException, IOException {

			List<Plane> planesList = new ArrayList<>();

			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();

			Document document = builder.parse( new FileInputStream( new File( resourceName ) ) );

			NodeList nodes = document.getDocumentElement().getChildNodes();

			for ( int i = 0; i < nodes.getLength(); i++ ) {
				Node node = nodes.item( i );

				if ( node instanceof Element ) {
					Plane plane = new Plane();

					plane.setNrName( node.getAttributes()
							.getNamedItem( "nrName" ).getNodeValue() );

					NodeList childNodes = node.getChildNodes();

					for ( int j = 0; j < childNodes.getLength(); j++ ) {
						Node childNode = childNodes.item( j );

						if ( childNode instanceof Element ) {

							switch ( childNode.getNodeName() ) {
							case "model":
								plane.setModel( childNode.getLastChild()
										.getTextContent() );
								break;
							case "origin":
								plane.setOrigin( childNode.getLastChild()
										.getTextContent() );
								break;
							case "price":
								plane.setPrice( Double.valueOf( childNode
										.getLastChild().getTextContent() ) );
								break;
							case "chars":
								setChars( plane, childNode );
								break;
							case "parameters":
								setParameters( plane, childNode );
								break;
							default:
								break;
							}

						}
					}
					planesList.add( plane );
				}
			}
			return planesList;
		}

		private void setChars( Plane plane, Node node ) {

			NodeList nodeList = node.getChildNodes();
			for ( int i = 0; i < nodeList.getLength(); i++ ) {
				Node childNode = nodeList.item( i );
				if ( childNode instanceof Element ) {

					switch ( childNode.getNodeName() ) {
					case "type":
						plane.setType( childNode.getLastChild()
								.getTextContent() );
					case "crew":
						plane.setCrew( Integer.valueOf( childNode
								.getLastChild().getTextContent() ) );
					case "armament":
						plane.setArmament( Integer.valueOf( childNode
								.getLastChild().getTextContent() ) );
					case "radar":
						plane.setHasRadar( childNode.getLastChild()
								.getTextContent() );
					default:
						break;
					}
				}

			}
		}

		private void setParameters( Plane plane, Node node ) {

			NodeList nodeList = node.getChildNodes();
			for ( int i = 0; i < nodeList.getLength(); i++ ) {
				Node childNode = nodeList.item( i );
				if ( childNode instanceof Element ) {

					switch ( childNode.getNodeName() ) {
					case "length":
						plane.setLength( Double.valueOf( childNode
								.getLastChild().getTextContent() ) );
					case "height":
						plane.setHeight( Double.valueOf( childNode
								.getLastChild().getTextContent() ) );
					case "width":
						plane.setWidth( Double.valueOf( childNode
								.getLastChild().getTextContent() ) );
					default:
						break;
					}
				}

			}
		}
	}
}
