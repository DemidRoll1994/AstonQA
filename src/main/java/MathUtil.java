public class MathUtil {
    public static long getFactorial(short value) {
        if (value < 0 || value > 20) throw new IllegalArgumentException();
        long result = 1;
        for (int factor = 2; factor <= value; factor++) {
            result *= factor;
        }
        return result;
    }
}
