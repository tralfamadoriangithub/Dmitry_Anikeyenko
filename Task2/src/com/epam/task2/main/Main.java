package com.epam.task2.main;

import com.epam.task2.entity.ProgrammingBook;
import com.epam.task2.parser.ProgrammingBookParser;
import com.epam.task2.util.ProgrammingBookUtil;

public class Main {

	private final static String filePath = "task2text.txt";

	public static void main( String[] args ) {

		ProgrammingBook book = ProgrammingBookParser.getBookFromFile( filePath );

		StringBuilder bookText = ProgrammingBookUtil.getBookText( book );
		System.out.println( bookText );

		System.out.println( "***********************************" );
		String palindrom = ProgrammingBookUtil.findMaxPalindrom( book );
		System.out.println( "Max Palindrom : " + palindrom );

		String uniqueWord = ProgrammingBookUtil.findUniqueWord( book );
		System.out.println( "Unique word : " + uniqueWord );

		System.out.println( "***********************************" );

		ProgrammingBookUtil.swapWords( book );
		bookText = ProgrammingBookUtil.getBookText( book );
		System.out.println( bookText );

	}

}
