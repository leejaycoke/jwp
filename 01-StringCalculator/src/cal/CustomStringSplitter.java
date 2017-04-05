package cal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by JuHyunLee on 2017. 4. 5..
 */
public class CustomStringSplitter implements StringSplitter {

    private String pattern = "//(.)\\n(.*)";

    @Override
    public void setValue(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public List<Positive> split(String string) {
        List<Positive> positives = new ArrayList<>();

        Matcher matcher = Pattern.compile(pattern).matcher(string);
        if (!matcher.find()) {
            return positives;
        }

        String[] numbers = matcher.group(2).replace(matcher.group(1), " ").split(" ");
        for (String number : numbers) {
            positives.add(new Positive(number));
        }
        return positives;
    }
}
