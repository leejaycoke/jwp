package cal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    Calculator cal;

    @Before
    public void setup() {
        cal = new Calculator();
    }

    @Test
    public void DelimiterStringSplitter_Test() {
        DelimiterStringSplitter splitter = new DelimiterStringSplitter();

        splitter.setValue(",");
        Assert.assertEquals(splitter.split("1,2,3").size(), 3);

        splitter.setValue("^");
        Assert.assertEquals(splitter.split("1^2^3").size(), 3);
    }

    @Test
    public void ComplexStringSplitter() {
        DelimiterStringSplitter splitter = new DelimiterStringSplitter();

        splitter.setValue(",|:");
        Assert.assertEquals(splitter.split("1,2:3").size(), 3);

        splitter.setValue("^|,");
        Assert.assertEquals(splitter.split("1^2,3").size(), 3);
    }

    @Test
    public void CustomStringSplitter() {
        CustomStringSplitter splitter = new CustomStringSplitter();
        Assert.assertEquals(splitter.split("//;\n1;2;3").size(), 3);
    }

    @Test
    public void 널값혹은빈값() {
        Assert.assertEquals(cal.add(null), 0);
        Assert.assertEquals(cal.add(""), 0);
        Assert.assertEquals(cal.add("       "), 0);
    }

    @Test
    public void 쉼표구분자_더하기() {
        DelimiterStringSplitter splitter = new DelimiterStringSplitter();
        splitter.setValue(",");
        cal.setStringSplitter(splitter);
        Assert.assertEquals(cal.add("1,2,3"), 6);
    }

    @Test
    public void 콜론구분자_더하기() {
        DelimiterStringSplitter splitter = new DelimiterStringSplitter();
        splitter.setValue(":");
        cal.setStringSplitter(splitter);
        Assert.assertEquals(cal.add("1:2:3"), 6);
    }

    @Test
    public void caret_더하기() {
        DelimiterStringSplitter splitter = new DelimiterStringSplitter();
        splitter.setValue("^");
        cal.setStringSplitter(splitter);
        Assert.assertEquals(cal.add("1^2^3"), 6);
    }

    @Test
    public void 쉼표와콜론섞어서_더하기() {
        ComplexStringSplitter splitter = new ComplexStringSplitter();
        cal.setStringSplitter(splitter);
        Assert.assertEquals(cal.add("1,2:3"), 6);
    }

    @Test
    public void 커스텀_더하기() {
        CustomStringSplitter splitter = new CustomStringSplitter();
        cal.setStringSplitter(splitter);
        Assert.assertEquals(cal.add("//;\n1;2;3"), 6);
        Assert.assertEquals(cal.add("//*\n1*2*3"), 6);
        Assert.assertEquals(cal.add("//^\n1^2^3"), 6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수_Exception() {
        DelimiterStringSplitter splitter = new DelimiterStringSplitter();
        cal.setStringSplitter(splitter);
        Assert.assertEquals(cal.add("-1,2,3"), 6);
    }

}