package com.epam.task2.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;

import com.epam.task2.entity.ProgrammingBook;
import com.epam.task2.entity.Sentence;
import com.epam.task2.entity.Text;

public class ProgrammingBookUtil {

	public static String findMaxPalindrom( ProgrammingBook book ) {

		if ( book == null ) {
			return null;
		}

		String maxPalindrom = "";

		HashMap<Integer, Sentence> sentences = book.getSentences();
		Set<Entry<Integer, Sentence>> entrySet = sentences.entrySet();
		Iterator<Entry<Integer, Sentence>> iterator = entrySet.iterator();

		while ( iterator.hasNext() ) {
			Map.Entry<Integer, Sentence> entry = iterator.next();
			Sentence sentence = entry.getValue();
			ArrayList<String> words = sentence.getWords();
			for ( String word : words ) {
				if ( isPolyndrom( word ) ) {
					if ( word.length() > maxPalindrom.length() ) {
						maxPalindrom = word;
					}
				}
			}
		}
		return maxPalindrom.length() > 0 ? maxPalindrom : "No polyndrom found";

	}

	public static String findUniqueWord( ProgrammingBook book ) {

		if ( book == null ) {
			return null;
		}

		String uniqueWord = "";

		HashMap<Integer, Sentence> sentences = book.getSentences();
		Set<Entry<Integer, Sentence>> entrySet = sentences.entrySet();
		Iterator<Entry<Integer, Sentence>> iterator = entrySet.iterator();
		Map.Entry<Integer, Sentence> entry = iterator.next();
		Sentence sentence = entry.getValue();
		ArrayList<String> words = sentence.getWords();

		Set<String> uniqueWords = new HashSet<>();
		Set<String> otherWords = new HashSet<>();

		uniqueWords.addAll( words );

		while ( iterator.hasNext() ) {
			entry = iterator.next();
			otherWords.addAll( entry.getValue().getWords() );
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

			HashMap<Integer, Sentence> sentences = book.getSentences();
			Set<Map.Entry<Integer, Sentence>> entrySet = sentences.entrySet();
			Iterator<Entry<Integer, Sentence>> iterator = entrySet.iterator();
			while ( iterator.hasNext() ) {
				Map.Entry<Integer, Sentence> entry = iterator.next();
				Sentence sentence = entry.getValue();
				String str = sentence.getText();
				sentence.setText( swap( str ) );
			}
		}
	}

	public static StringBuilder getBookText( ProgrammingBook book ) {

		if ( book == null ) {
			return null;
		}
		
		StringBuilder bookText = new StringBuilder();
		TreeMap<Integer, Text> bookTree = new TreeMap<>();
		bookTree.putAll( book.getCode() );
		bookTree.putAll( book.getSentences() );
		bookTree.forEach( ( a, b ) -> bookText.append( b.getText() ) );
		return bookText;
	}

	private static boolean isPolyndrom( String word ) {
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
		String first = sentence.substring( 0, sentence.indexOf( " " ) );
		int lastIndex = sentence.lastIndexOf( " " );
		if ( lastIndex == sentence.length() - 1 ) {
			lastIndex = sentence.substring( 0, sentence.length() - 1 )
					.lastIndexOf( " " );
		}
		String last = sentence.substring( lastIndex + 1, sentence.length() - 2 );
		String remain = sentence.substring( sentence.indexOf( " " ),
				sentence.lastIndexOf( " " ) );
		return last + remain + " " + first
				+ sentence.charAt( sentence.length() - 1 );

	}
}
