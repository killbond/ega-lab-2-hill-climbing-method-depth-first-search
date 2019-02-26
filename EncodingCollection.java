import java.util.ArrayList;
import java.util.Collections;

public class EncodingCollection {

    private ArrayList<Encoding> collection;

    private int length;

    public EncodingCollection(int length) {
        this.length = length;
        this.collection = new ArrayList<Encoding>();
        for (int i = 0; i < Math.pow(2, length); i++) {
            this.collection.add(new Encoding(i));
        }
    }

    public EncodingCollection(ArrayList<Encoding> collection, int length) {
        this.length = length;
        this.collection = collection;
    }

    public int getLength() {
        return this.collection.size();
    }

    public Encoding getRandom() {
        int position = (int)(Math.random() * this.getLength());
        return this.collection.get(position);
    }

    public EncodingCollection getSurroundings(Encoding from) {
        int distance = 0;
        ArrayList<Encoding> result = new ArrayList<Encoding>();
        for (Encoding current : this.collection) {
            distance = this.hammingDistance(from.toString(this.length), current.toString(this.length));
            if (1 == distance) {
                result.add(current);
            }
        }
        return new EncodingCollection(result, this.length);
    }

    public ArrayList<Encoding> asList() {
        return this.collection;
    }

    public String toString() {
        String result = "";
        for (Encoding current : this.collection) {
            result += current.toString(this.length) + " (" +
                current.getAdaptability().square(this.length) + "), ";
        }

        if (result.length() > 2) {
            result = result.substring(0, result.length() - 2);
        }

        return result;
    }

    private int hammingDistance(String right, String left) {
        if (left == null || right == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        if (left.length() != right.length()) {
            throw new IllegalArgumentException("Strings must have the same length");
        }

        int distance = 0;

        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) != right.charAt(i)) {
                distance++;
            }
        }

        return distance;
    }
}
