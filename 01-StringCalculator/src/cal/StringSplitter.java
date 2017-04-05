package cal;

import java.util.List;

/**
 * Created by JuHyunLee on 2017. 4. 5..
 */
public interface StringSplitter {

    void setValue(String value);

    List<Positive> split(String string);

}
