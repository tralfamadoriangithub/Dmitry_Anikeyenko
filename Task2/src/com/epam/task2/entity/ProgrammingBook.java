package com.epam.task2.entity;

import java.util.HashMap;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ( ( codeMap == null ) ? 0 : codeMap.hashCode() );
		result = prime * result
				+ ( ( sentenceMap == null ) ? 0 : sentenceMap.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( obj == null )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		ProgrammingBook other = (ProgrammingBook) obj;
		if ( codeMap == null ) {
			if ( other.codeMap != null )
				return false;
		} else if ( !codeMap.equals( other.codeMap ) )
			return false;
		if ( sentenceMap == null ) {
			if ( other.sentenceMap != null )
				return false;
		} else if ( !sentenceMap.equals( other.sentenceMap ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [codeMap=" + codeMap + ", sentenceMap="
				+ sentenceMap + "]";
	}
	
	
}
