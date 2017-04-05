package cal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    Calculator cal;

    @Before
    public void setup() {
        cal = new Calculator();
    }

    @Test
    public void 쉼표파싱() {
        assertThat(cal.split("1,2,3"), is(new String[]{"1", "2", "3"}));
    }

    @Test
    public void 콜론파싱() {
        assertThat(cal.split("1:2:3"), is(new String[]{"1", "2", "3"}));
    }

    @Test
    public void 널값혹은빈값() {
        Assert.assertEquals(cal.add(null), 0);
        Assert.assertEquals(cal.add(""), 0);
        Assert.assertEquals(cal.add("       "), 0);
    }

    @Test
    public void 쉼표구분자_더하기() {
        Assert.assertEquals(cal.add("1,2,3"), 6);
    }

    @Test
    public void 콜론구분자_더하기() {
        Assert.assertEquals(cal.add("1:2:3"), 6);
    }

    @Test
    public void 쉼표와콜론섞어서_더하기() {
        Assert.assertEquals(cal.add("1,2:3"), 6);
    }

    @Test
    public void 커스텀_더하기() {
        Assert.assertEquals(cal.add("//;\n1;2;3"), 6);
        Assert.assertEquals(cal.add("//*\n1*2*3"), 6);
        Assert.assertEquals(cal.add("//^\n1^2^3"), 6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수_Exception() {
        Assert.assertEquals(cal.add("-1,2,3"), 6);
        Assert.assertEquals(cal.add("-1,2,-3"), 6);
        Assert.assertEquals(cal.add("//*\n1*-2*3"), 6);
        Assert.assertEquals(cal.add("1:-2:3"), 6);
    }

}