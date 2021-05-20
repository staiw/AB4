package de.uniheidelberg.cl.java.ex04;

import ex04.PointerMother;

public class Token extends PointerMother {
	private String surface;
	
	public Token(int id, String surface, String lemma, String pos, int head, String rel) {
		super();
		this.id = id;
		this.surface = surface;
		this.lemma = lemma;
		this.pos = pos;
		this.rel = rel;
		this.head = head;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + head;
		result = prime * result + id;
		result = prime * result + ((lemma == null) ? 0 : lemma.hashCode());
		result = prime * result + ((rel == null) ? 0 : rel.hashCode());
		result = prime * result + ((surface == null) ? 0 : surface.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;			
		}
		if (!(obj instanceof Token)) {
			return false;			
		}
		Token other = (Token) obj;
		return surface.equals(other.surface) && lemma.equals(other.lemma) && pos.equals(other.pos);
	}
}
