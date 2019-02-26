public class Adaptability {

    private int value;

    Adaptability(int value) {
        this.value = value;
    }

    public int number() {
        return this.value;
    }

    public int random(int length) {
        return (int) (Math.random() * (Math.pow(2, length) + 1));
    }

    public int square(int length) {
        return (int) Math.pow(this.value - Math.pow(2, length), 2);
    }
}
