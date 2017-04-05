package cal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JuHyunLee on 2017. 4. 5..
 */
public class ComplexStringSplitter implements StringSplitter {

    private String value = ",|\\:";

    @Override
    public void setValue(String value) {
    }

    @Override
    public List<Positive> split(String string) {
        List<Positive> positives = new ArrayList<>();
        for (String value : string.split(value)) {
            positives.add(new Positive(value));
        }
        return positives;
    }
}
