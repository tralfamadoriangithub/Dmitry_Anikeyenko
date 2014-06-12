package com.epam.task2.parser;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.task2.entity.ProgrammingBook;

public class ProgrammingBookParser {

	private Logger log = Logger
			.getLogger( com.epam.task2.parser.ProgrammingBookParser.class );

	private final String SENTENCE_PATTERN = "[A-Z][^\\u002E]*[\\u002E\\u003A][\\s]";
	private final String PLAIN_TEXT_PATTERN = "^\\s*[A-Z0-9]{1}[.[^\\n]]+[^\\u003B]\\s$";
	private final String CODE_BLOCK_START_PATTERN = "^[a-z].*";
	private final String CODE_BLOCK_END_PATTERN = "^\\u007D";

	private List<String> textStringArray;
	private ProgrammingBook book;

	private Map<Integer, String> plainText;

	private ProgrammingBookParser() {
		book = new ProgrammingBook();
	}

	public static ProgrammingBook getBookFromFile( String filePath ) {
		
		if ( filePath.isEmpty() || filePath == null ) {
			return null;
		}

		ProgrammingBookParser parser = new ProgrammingBookParser();
		parser.readFile( filePath );
		parser.parseForText();
		parser.parseForCode();
		parser.parseForSentences();

		return parser.book;
	}

	private void readFile( String filePath ) {
		
		textStringArray = new ArrayList<>();
		
		try ( BufferedReader reader = new BufferedReader( new FileReader(
				filePath ) ) ) {
			String line = reader.readLine();
			while ( line != null ) {
				textStringArray.add( line + '\n' );
				line = reader.readLine();
			}
		} catch ( IOException e ) {
			log.error( "Error ", e );
		}
	}

	private void parseForText() {
		
		plainText = new LinkedHashMap<>();
		
		Pattern plainTextPattern = Pattern.compile( PLAIN_TEXT_PATTERN );
		Matcher plainTextMatcher;
		
		int index = 0;
		for ( String string : textStringArray ) {
			plainTextMatcher = plainTextPattern.matcher( string );
			if ( plainTextMatcher.find() ) {
				do {
					plainText.put( index, string );
					index += plainTextMatcher.group().length();
				} while ( plainTextMatcher.find() );
			} else {
				index += string.length();
			}
		}
	}

	private void parseForCode() {
		Pattern codeStartPattern = Pattern.compile( CODE_BLOCK_START_PATTERN );
		Pattern codeEndPattern = Pattern.compile( CODE_BLOCK_END_PATTERN );

		Matcher codeStartMatcher;
		Matcher codeEndMatcher;

		int index = 0;
		int i = 0;
		while ( i < textStringArray.size() ) {
			String string = textStringArray.get( i );
			index += string.length();
			codeStartMatcher = codeStartPattern.matcher( string );
			if ( codeStartMatcher.find() ) {
				book.setCode( index, string );
				int j = i + 1;
				while ( j < textStringArray.size() ) {
					string = textStringArray.get( j );
					codeEndMatcher = codeEndPattern.matcher( string );
					if ( codeEndMatcher.find() ) {
						index += string.length();
						book.setCode( index, string );
						i = j;
						break;
					}
					index += string.length();
					book.setCode( index, string );
					j++;
				}
			}
			i++;
		}
	}

	private void parseForSentences() {

		Pattern sentencePattern = Pattern.compile( SENTENCE_PATTERN );
		Matcher sentenceMatcher;
		
		Set<Entry<Integer, String>> entrySet = plainText.entrySet();
		Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
		
		while ( iterator.hasNext() ) {
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) iterator
					.next();
			String text = entry.getValue();
			int index = entry.getKey().intValue();
			sentenceMatcher = sentencePattern.matcher( text );
			if ( sentenceMatcher.find() ) {
				do {
					book.setSentence( index, sentenceMatcher.group() );
					index += sentenceMatcher.group().length();
				} while ( sentenceMatcher.find() );

			} else {
				book.setSentence( index, text );
			}
		}
	}
}
