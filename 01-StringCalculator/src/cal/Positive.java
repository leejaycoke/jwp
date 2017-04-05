package cal;

public class Positive {

    private int number;

    public Positive(int number) {
        this.number = number;
    }

    public Positive(String number) {
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }

}
