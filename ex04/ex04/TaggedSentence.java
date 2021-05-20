package de.uniheidelberg.cl.java.ex04;

import java.util.ArrayList;
import java.util.List;
import ex04.TaggedMother;


public class TaggedSentence extends Sentence implements TaggedMother {
	protected List<String> tags;
	
	private static List<String> emptyList(int size) {
		List<String> l = new ArrayList<>(size);
		
		for (int i = 0; i < size; i++) {
			l.add(null);
		}
		
		return l;
	}

	public TaggedSentence(List<String> tokens) {
		this(tokens, TaggedSentence.emptyList(tokens.size()));
	}

	public TaggedSentence(List<String> tokens, List<String> tags) {
		super(tokens);
		this.tags = new ArrayList<>(tags);
	}
	
	public String getTokenTag(int position) {
		return this.tags.get(position);
	}
}