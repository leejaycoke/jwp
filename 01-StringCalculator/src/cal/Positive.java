package cal;

public class Positive {

    private int number;

    public Positive(int number) {
        if (number < 0) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }
        this.number = number;
    }

    public Positive(String number) {
        if (number.startsWith("-")) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }

}
