package de.uniheidelberg.cl.java.ex04;

import java.util.List;
import ex04.TaggableMother;
import jdk.javadoc.doclet.Taglet;

public class TaggableSentence extends TaggedSentence implements TaggableMother {
	public TaggableSentence(List<String> tokens, List<String> tags) {
		super(tokens, tags);
	}
	
	public void setTokenTag(int position, String value) {
		this.tags.set(position, value);
	}
}
