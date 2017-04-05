package cal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private Pattern p = Pattern.compile("//(.)\n(.*)");

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

//    StringSplitter getValidSplitter(String string, int index) {
//        if (stringSplitters.get(index).isValid(string)) {
//            return stringSplitters.get(index);
//        }
//
//        if (index == stringSplitters.size() - 1) {
//            return null;
//        }
//
//        return getValidSplitter(string, ++index);
//    }


    String[] split(String string) {
        Matcher matcher = p.matcher(string);
        if (matcher.matches()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).replace(delimiter, ",").split(",");
        }

        return string.split(",|:");
    }

    boolean validate(String[] string, int index) {
        if (string[index].startsWith("-")) {
            return false;
        }

        if (index == string.length - 1) {
            return true;
        }

        return validate(string, ++index);
    }

    List<Positive> convertToPositive(String[] numbers) {
        List<Positive> positives = new ArrayList<>();
        for (String number : numbers) {
            positives.add(new Positive(number));
        }
        return positives;
    }

}
