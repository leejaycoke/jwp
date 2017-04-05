package cal;

import java.util.List;

public class Calculator {

    private StringSplitter stringSplitter;

    void setStringSplitter(StringSplitter stringSplitter) {
        this.stringSplitter = stringSplitter;
    }

    int add(String string) {
        if (string == null || string.trim().equals("")) {
            return 0;
        }

        if (stringSplitter == null) {
            return 0;
        }

        List<Positive> positives = stringSplitter.split(string);

        int total = 0;
        for (Positive positive : positives) {
            total += positive.getNumber();
        }

        return total;
    }

}
