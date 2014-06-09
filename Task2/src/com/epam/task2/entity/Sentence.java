package com.epam.task2.entity;

import java.util.ArrayList;

public class Sentence extends Text {
	private ArrayList<String> words;
	private ArrayList<Character> characters;

	{
		words = new ArrayList<>();
		characters = new ArrayList<>();
	}

	public Sentence() {
	}

	public ArrayList<String> getWords() {
		return words;
	}

	public void setWords( ArrayList<String> words ) {
		this.words = words;
	}

	public void setWords( String string ) {
		if ( !"".equals( string ) || !" ".equals( string ) ) {
			words.add( string );
		}
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void setCharacters( ArrayList<Character> characters ) {
		this.characters = characters;
	}

	public void setCharacters( char ch ) {
		if ( ch != ' ' && ch != '\n' ) {
			characters.add( ch );
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ( ( characters == null ) ? 0 : characters.hashCode() );
		result = prime * result + ( ( words == null ) ? 0 : words.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( !super.equals( obj ) )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		Sentence other = (Sentence) obj;
		if ( characters == null ) {
			if ( other.characters != null )
				return false;
		} else if ( !characters.equals( other.characters ) )
			return false;
		if ( words == null ) {
			if ( other.words != null )
				return false;
		} else if ( !words.equals( other.words ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		// return "Sentence [words=" + words + ", characters=" + characters +
		// "]";
		return super.toString();
	}

}
