package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    private String original;

    public ReversedSequence(String original) {
        this.original = original;
    }

    @Override
    public int length() {
        return original.length();
    }

    @Override
    public char charAt(int index) {
        return original.charAt(length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new ReversedSequence(original.substring(length() - end, length() - start));
    }

    @Override
    public String toString() {
        StringBuilder reversed = new StringBuilder(original);
        return reversed.reverse().toString();
    }
}
// END
