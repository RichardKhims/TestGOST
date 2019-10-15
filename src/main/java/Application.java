import utils.NumberStringifierUtils;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println(NumberStringifierUtils.stringifyRange(1,100, Arrays.asList(2,7)));
    }
}
