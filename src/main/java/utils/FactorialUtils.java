package utils;

import java.util.stream.IntStream;

public class FactorialUtils {
    public static int calcFactorial(int num) throws Exception {
        if (num < 0) {
            throw new Exception("Non positive value");
        }

        if (num < 2) {
            return 1;
        }

        return IntStream.range(2, num + 1).reduce(1, (res, value) -> res * value);
    }

    public static double calcF(int m, int r) throws Exception {
        int a = Integer.min(m - r, r);
        int b = Integer.max(m - r, r);

        int aFactorial = calcFactorial(a);
        int bFactorial = IntStream.range(a + 1, b + 1).reduce(aFactorial, (res, value) -> res * value);
        int mFactorial = IntStream.range(b + 1, m + 1).reduce(bFactorial, (res, value) -> res * value);

        return mFactorial / (aFactorial * bFactorial);
    }
}
