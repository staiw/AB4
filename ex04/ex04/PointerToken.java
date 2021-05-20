package de.uniheidelberg.cl.java.ex04;

public class PointerToken extends Token {
    private String original;
    private int start;
    private int length;

    public PointerToken(int id, String surface, int start, int length, String lemma, String pos, int head, String rel) {
        super(id, surface, lemma, pos, head, rel);
        this.original = surface;
        this.start = start;
        this.length = length;
    }

    @Override
    public String getSurface() {
        String surfaceToken = original.substring(start, start + length);
        return surfaceToken;
    }

    //public void setSurface(String surface) {
    //    this.surface = surface;
    //}



    //public void setHead(int headStart, int headLength) {
    //    this.headStart = headStart, this.headLength = headLength;
    //}



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + start;
        result = prime * result + length;
        result = prime * result + ((original == null) ? 0 : original.hashCode());
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
        if (!(obj instanceof PointerToken)) {
            return false;
        }
        PointerToken other = (PointerToken) obj;
        return original.equals(other.original) ;
    }
}
