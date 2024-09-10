import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class TestFactorial {
    @DataProvider
    public Object[][] positiveFactorialTest() {
        return new Object[][]{
                {(short) 0, 1L},
                {(short) 1, 1L},
                {(short) 20, 2432902008176640000L}};
    }
    @DataProvider
    public Object[] negativeFactorialTest() {
        return new Object[]{
                (short) -1,
                (short) 21};
    }
    @Test(dataProvider = "positiveFactorialTest", testName = "{1} is a factorial of {0}")
    void positiveFactorialTest(short value, Long result) {
        assertEquals(MathUtil.getFactorial(value), result);
    }
    @Test(dataProvider = "negativeFactorialTest", testName = "{0} is incorrect value")
    void testFactorialIllegalArgumentException(short value) {
        assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(value));
    }
}
