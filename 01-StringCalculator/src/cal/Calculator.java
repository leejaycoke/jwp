package cal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private Pattern p = Pattern.compile("//(.)\n(.*)");

    int add(String strings) {
        if (strings == null || strings.trim().equals("")) {
            return 0;
        }

        String[] numbers = split(strings);
        if (!validate(numbers, 0)) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }

        List<Positive> positives = convertToPositive(numbers);

        int total = 0;
        for (Positive positive : positives) {
            total += positive.getNumber();
        }

        return total;
    }

    String[] split(String strings) {
        Matcher matcher = p.matcher(strings);
        if (matcher.matches()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).replace(delimiter, ",").split(",");
        }
        return strings.split(",|:");

    }

    boolean validate(String[] strings, int index) {
        if (strings[index].startsWith("-")) {
            return false;
        }

        if (index == strings.length - 1) {
            return true;
        }

        return validate(strings, ++index);
    }

    List<Positive> convertToPositive(String[] numbers) {
        List<Positive> positives = new ArrayList<>();
        for (String number : numbers) {
            positives.add(new Positive(number));
        }
        return positives;
    }

}
