package com.epam.task2.parser;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.task2.entity.ProgrammingBook;
import com.epam.task2.entity.Sentence;

public class ProgrammingBookParser {

	private Logger log = Logger
			.getLogger( com.epam.task2.parser.ProgrammingBookParser.class );

	private final String SENTENCE_PATTERN = "[A-Z][^\\u002E]*[\\u002E\\u003A][\\s]";
	private final String PLAIN_TEXT_PATTERN = "^\\s*[A-Z0-9]{1}[.[^\\n]]+[^\\u003B]\\s$";
	private final String CODE_BLOCK_START_PATTERN = "^[a-z].*";
	private final String CODE_BLOCK_END_PATTERN = "^\\u007D";
	private final String WORD_PATTERN = "([\\w]+[\\u0027]?[\\w]+)[\\s.,:;><='()-]+";
	private final String CHAR_PATTERN = "[.,:;><='()-]";

	// private final String CODE_BLOCK_START1 = ".+\\n+[a-z]";
	// private final String CODE_BLOCK_END1 = ".*\\u007D\\n+[A-Z0-9]";

	private ArrayList<String> textStringArray;
	private ProgrammingBook book;

	private Map<Integer, String> plainText;

	public ProgrammingBookParser( ProgrammingBook book ) {
		this.book = book;
	}

	public void parseTextFile( String filePath ) {
		readFile( filePath );
		parseForText();
		parseForCode();
		parseForSentences();
		sentenceDissection();
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
		plainText = new HashMap<>();
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

	// private void parseForCode1() {
	// Pattern codeStartPattern = Pattern.compile(CODE_BLOCK_START1);
	// Pattern codeEndPattern = Pattern.compile(CODE_BLOCK_END1);
	//
	// Matcher codeStartMatcher = codeStartPattern.matcher(text);
	// Matcher codeEndMatcher = codeEndPattern.matcher(text);
	//
	// while (codeStartMatcher.find()) {
	// if (codeEndMatcher.find()) {
	// book.setCode(codeStartMatcher.end(), text.substring(
	// codeStartMatcher.end() - 1, codeEndMatcher.end() - 1));
	// }
	// }
	// }

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
		// TreeMap<Integer, Text> tm = new TreeMap<>();
		// tm.putAll(book.getCode());
		// tm.forEach((a, b) -> {
		// System.out.print("{" + a + "}");
		// System.out.print(b);
		// });
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
		// TreeMap<Integer, Text> tm = new TreeMap<>();
		// tm.putAll(book.getSentence());
		// tm.forEach((a, b) -> {
		// System.out.print("{" + a + "}");
		// System.out.println(b);
		// });
	}

	private void sentenceDissection() {
		HashMap<Integer, Sentence> sentences = book.getSentences();
		Set<Entry<Integer, Sentence>> entrySet = sentences.entrySet();
		Iterator<Entry<Integer, Sentence>> iterator = entrySet.iterator();
		while ( iterator.hasNext() ) {
			Map.Entry<Integer, Sentence> entry = iterator.next();
			Sentence sentence = entry.getValue();
			String text = sentence.getText();
			sentence.setWords( parseForWords( text ) );
			sentence.setCharacters( parseForChars( text ) );
		}
	}

	private ArrayList<String> parseForWords( String string ) {
		ArrayList<String> words = new ArrayList<>();
		Pattern wordPattern = Pattern.compile( WORD_PATTERN );
		Matcher wordMatcher = wordPattern.matcher( string );
		while ( wordMatcher.find() ) {
			words.add( wordMatcher.group( 1 ) );
		}
		return words;
	}

	private ArrayList<Character> parseForChars( String string ) {
		ArrayList<Character> chars = new ArrayList<>();
		Pattern charPattern = Pattern.compile( CHAR_PATTERN );
		Matcher charMatcher = charPattern.matcher( string );
		while ( charMatcher.find() ) {
			chars.add( charMatcher.group().charAt( 0 ) );
		}
		return chars;
	}

}
