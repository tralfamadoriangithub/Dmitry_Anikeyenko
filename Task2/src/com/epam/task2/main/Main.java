package com.epam.task2.main;

import com.epam.task2.entity.ProgrammingBook;
import com.epam.task2.util.ProgrammingBookUtil;

public class Main {

	private final static String filePath = "task2text.txt";

	public static void main( String[] args ) {
		ProgrammingBook book = ProgrammingBookUtil
				.getProgrammingBook( filePath );

		String palindrom = ProgrammingBookUtil.findMaxPalindrom( book );
		System.out.println( "Palindrom : " + palindrom );

		String uniqueWord = ProgrammingBookUtil.findUniqueWord( book );
		System.out.println( "Unique word : " + uniqueWord );

		System.out.println( "***********************************" );
		System.out.println( book.getBookText() );

		System.out.println( "***********************************" );
		ProgrammingBookUtil.swapWords( book );
		System.out.println( book.getBookText() );

	}

}
