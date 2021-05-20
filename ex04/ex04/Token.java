package de.uniheidelberg.cl.java.ex04;

public class Token {
	private String surface;
	private String lemma;
	private String pos;
	private String rel;
	private int id;
	private int head;

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

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHead() {
		return head;
	}

	public void setHead(int head) {
		this.head = head;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
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
