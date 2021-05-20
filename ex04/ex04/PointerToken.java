package ex04;
import ex04.PointerMother;

public class PointerToken extends PointerMother {
    private String original;
    private int start;
    private int length;



    public PointerToken(String original, int start, int length) {
        this.original = original;
        this.start = start;
        this.length = length;
    }
    public PointerToken(int id, String original, int start, int length, String lemma, String pos, int head, String rel) {
        this.id = id;
        this.original = original;
        this.start = start;
        this.length = length;
        this.lemma = lemma;
        this.pos = pos;
        this.rel = rel;
        this.head = head;
    }

    public String getSurface() {
        String surfaceToken = original.substring(start, start + length - 1);
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
