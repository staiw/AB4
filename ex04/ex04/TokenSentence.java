package de.uniheidelberg.cl.java.ex04;

import ex04.TokenMother;
import ex04.TaggableMother;
import ex04.TaggedMother;
import java.util.ArrayList;
import ex04.DependencyMother;
import java.util.List;

public class TokenSentence implements TokenMother, TaggableMother, TaggedMother, DependencyMother {
	protected List<Token> tokens;
	
	public TokenSentence(List<Token> tokens) {
		this.tokens = new ArrayList<>(tokens);
	}
	
	public int getLength() {
		return this.tokens.size();
	}
	
	public String getTokenText(int position) {
		return this.tokens.get(position).getSurface();
	}
	
	public String getTokenTag(int position) {
		return this.tokens.get(position).getPos();
	}

	public void setTokenTag(int position, String value) {
		this.tokens.get(position).setPos(value);
	}
	
	public Token getToken(int position) {
		return this.tokens.get(position);
	}
	
	public int getTokenHead(int position) {
		return this.getToken(position).getHead();
	}

	public String getTokenRel(int position) {
		return this.getToken(position).getRel();
	}
}
