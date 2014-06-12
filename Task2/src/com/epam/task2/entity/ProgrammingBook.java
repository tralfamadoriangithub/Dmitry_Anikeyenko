package com.epam.task2.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProgrammingBook {

	private Map<Integer, String> codeMap;
	private Map<Integer, String> sentenceMap;

	public ProgrammingBook() {
		codeMap = new LinkedHashMap<>();
		sentenceMap = new LinkedHashMap<>();
	}

	public Map<Integer, String> getCode() {
		return codeMap;
	}

	public String getCode( int index ) {
		return codeMap.get( index );
	}

	public void setCode( Map<Integer, String> codeMap ) {
		this.codeMap = codeMap;
	}

	public void setCode( int index, String code ) {
		codeMap.put( index, code );
	}

	public Map<Integer, String> getSentences() {
		return sentenceMap;
	}

	public String getSentence( int index ) {
		return sentenceMap.get( index );
	}

	public void setSentences( Map<Integer, String> sentence ) {
		this.sentenceMap = sentence;
	}

	public void setSentence( int index, String sentence ) {
		sentenceMap.put( index, sentence );
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
		return getClass().getSimpleName() + " [codeMap=" + codeMap
				+ ", sentenceMap=" + sentenceMap + "]";
	}

}
