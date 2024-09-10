
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class Main {

    @ParameterizedTest(name = "{1} is a factorial of {0}")
    @CsvSource(value = {
            "0, 1",
            "1, 1",
            "20, 2432902008176640000"})
    void testFactorial(short value, Long result) {
        assertEquals(MathUtil.getFactorial(value), result);
    }

    @ParameterizedTest(name = "{0} is incorrect value")
    @ValueSource(shorts = {-1, 21})
    void testFactorialIllegalArgumentException(short value) {
        assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(value));
    }
}
