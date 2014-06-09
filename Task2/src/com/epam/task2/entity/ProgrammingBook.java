package com.epam.task2.entity;

import java.util.HashMap;
import java.util.TreeMap;

public class ProgrammingBook {

	private HashMap<Integer, Text> codeMap;
	private HashMap<Integer, Sentence> sentenceMap;

	public ProgrammingBook() {
		codeMap = new HashMap<>();
		sentenceMap = new HashMap<>();
	}

	public HashMap<Integer, Text> getCode() {
		return codeMap;
	}

	public Text getCode( int index ) {
		return codeMap.get( index );
	}

	public void setCode( HashMap<Integer, Text> codeMap ) {
		this.codeMap = codeMap;
	}

	public void setCode( int index, String code ) {
		Text codeText = new Text();
		codeText.setText( code );
		codeMap.put( index, codeText );
	}

	public void setCode( int index, Text code ) {
		codeMap.put( index, code );
	}

	public HashMap<Integer, Sentence> getSentences() {
		return sentenceMap;
	}

	public Sentence getSentence( int index ) {
		return sentenceMap.get( index );
	}

	public void setSentences( HashMap<Integer, Sentence> sentence ) {
		this.sentenceMap = sentence;
	}

	public void setSentence( int index, Sentence sentence ) {
		sentenceMap.put( index, sentence );
	}

	public void setSentence( int index, String sentence ) {
		Sentence sentenceString = new Sentence();
		sentenceString.setText( sentence );
		sentenceMap.put( index, sentenceString );
	}

	public StringBuilder getBookText() {
		StringBuilder bookText = new StringBuilder();
		TreeMap<Integer, Text> book = new TreeMap<>();
		book.putAll( codeMap );
		book.putAll( sentenceMap );
		book.forEach( ( a, b ) -> bookText.append( b ) );
		return bookText;
	}

}
