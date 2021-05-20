package de.uniheidelberg.cl.java.ex04;


import ex04.TokenMother;
import java.util.List;
import java.util.ArrayList;


public class Sentence implements TokenMother {
	protected List<String> tokens;
	
	public Sentence(List<String> tokens) {
		this.tokens = new ArrayList<String>(tokens);
	}
	
	public String getTokenText(int position) {
		return this.tokens.get(position);
	}
	
	public int getLength() {
		return this.tokens.size();
	}
}
