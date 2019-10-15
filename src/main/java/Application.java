import utils.FactorialUtils;
import utils.NumberStringifierUtils;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) throws Exception {
        System.out.println("task 1: " + NumberStringifierUtils.stringifyRange(1,100, Arrays.asList(2,7)));

        System.out.println("task 2: " + FactorialUtils.calcF(6,2));
    }
}
