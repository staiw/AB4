package de.uniheidelberg.cl.java.ex04;

import ex04.DependencyMother;
import java.util.List;
import java.util.ArrayList;

public class DependencySentence extends Sentence implements DependencyMother {
	private List<Integer> heads;
	private List<String> rels;

	public DependencySentence(List<String> tokens, List<Integer> heads, List<String> rels) {
		super(tokens);
		
		this.heads = new ArrayList<>(heads);
		this.rels = new ArrayList<>(rels);
	}
	
	public int getTokenHead(int position) {
		return this.heads.get(position);
	}

	public String getTokenRel(int position) {
		return this.rels.get(position);
	}
}
