package com.epam.task2.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.task2.entity.ProgrammingBook;

public class ProgrammingBookUtil {

	public static String findMaxPalindrom( ProgrammingBook book ) {

		if ( book == null ) {
			return null;
		}

		String maxPalindrom = "";
		Set<String> words = UtilParser.getWordsSet( book.getSentences() );
		for ( String word : words ) {
			if ( isPalindrom( word ) ) {
				if ( word.length() > maxPalindrom.length() ) {
					maxPalindrom = word;
				}
			}
		}
		return maxPalindrom.isEmpty() ? "No palindrom found" : maxPalindrom;
	}

	public static String findUniqueWord( ProgrammingBook book ) {

		if ( book == null ) {
			return null;
		}
		
		String uniqueWord = "";
		
		Map<Integer, String> sentences = book.getSentences();
		Set<Entry<Integer, String>> entrySet = sentences.entrySet();
		Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
		Map.Entry<Integer, String> entry = iterator.next();

		Set<String> uniqueWords = new HashSet<>();
		Set<String> otherWords = new HashSet<>();

		uniqueWords.addAll( UtilParser.parseForWords( entry.getValue() ) );

		while ( iterator.hasNext() ) {
			entry = iterator.next();
			otherWords.addAll( UtilParser.parseForWords( entry.getValue() ) );
		}

		for ( String word : uniqueWords ) {
			if ( !otherWords.contains( word ) ) {
				uniqueWord = word;
				break;
			}
		}
		return uniqueWord.isEmpty() ? "There is no unique words" : uniqueWord;
	}

	public static void swapWords( ProgrammingBook book ) {

		if ( book != null ) {

			Map<Integer, String> sentences = book.getSentences();

			for ( Map.Entry<Integer, String> entry : sentences.entrySet() ) {
				String newString = swap( entry.getValue() );
				entry.setValue( newString );
			}
		}
	}

	public static StringBuilder getBookText( ProgrammingBook book ) {

		if ( book == null ) {
			return null;
		}

		StringBuilder bookText = new StringBuilder();
		TreeMap<Integer, String> bookTree = new TreeMap<>();
		bookTree.putAll( book.getCode() );
		bookTree.putAll( book.getSentences() );
		bookTree.forEach( ( a, b ) -> bookText.append( b ) );
		return bookText;
	}

	private static boolean isPalindrom( String word ) {

		if ( word == null || word.length() < 2 || word.isEmpty() ) {
			return false;
		}
		StringBuilder sbWord = new StringBuilder( word );
		if ( word.equalsIgnoreCase( sbWord.reverse().toString() ) ) {
			return true;
		}
		return false;
	}

	private static String swap( String sentence ) {

		StringBuilder tempString = null;

		Pattern firstWordPattern = Pattern.compile( "([\\w]+)[\\u002C]?[\\s]" );
		Pattern lastWordPattern = Pattern.compile( "([\\w]+)[.?!:]" );
		Matcher firstWordMatcher = firstWordPattern.matcher( sentence );
		Matcher lastWordMatcher = lastWordPattern.matcher( sentence );

		if ( firstWordMatcher.find() && lastWordMatcher.find() ) {

			int firstStart = firstWordMatcher.start( 1 );
			int firstEnd = firstWordMatcher.end( 1 );
			int lastStart = lastWordMatcher.start( 1 );
			int lastEnd = lastWordMatcher.end( 1 );

			tempString = new StringBuilder( sentence );

			tempString.delete( lastStart, lastEnd );
			tempString.insert( lastStart,
					sentence.substring( firstStart, firstEnd ) );

			tempString.delete( firstStart, firstEnd );
			tempString.insert( firstStart,
					sentence.substring( lastStart, lastEnd ) );

		}
		return tempString == null ? sentence : tempString.toString();
	}

	private static class UtilParser {

		private static Set<String> getWordsSet( Map<Integer, String> sentences ) {

			Set<String> words = new HashSet<>();

			for ( Map.Entry<Integer, String> entry : sentences.entrySet() ) {
				words.addAll( parseForWords( entry.getValue() ) );
			}
			return words;
		}

		private static ArrayList<String> parseForWords( String string ) {

			final String WORD_PATTERN = "([\\w]+[\\u0027]?[\\w]+)[\\s.,:;><='()-]+";
			ArrayList<String> words = new ArrayList<>();
			Pattern wordPattern = Pattern.compile( WORD_PATTERN );
			Matcher wordMatcher = wordPattern.matcher( string );

			while ( wordMatcher.find() ) {
				words.add( wordMatcher.group( 1 ) );
			}
			return words;
		}
	}
}
