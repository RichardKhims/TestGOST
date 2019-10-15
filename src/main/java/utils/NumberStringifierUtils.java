package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberStringifierUtils {
    private static final Map<Integer, String> digitWordMap;
    static {
        digitWordMap = new HashMap<>();
        digitWordMap.put(1, "One");
        digitWordMap.put(2, "Two");
        digitWordMap.put(3, "Three");
        digitWordMap.put(4, "Four");
        digitWordMap.put(5, "Five");
        digitWordMap.put(6, "Six");
        digitWordMap.put(7, "Seven");
        digitWordMap.put(8, "Eigght");
        digitWordMap.put(9, "Nine");
    }

    public static List<String> stringifyRange(Integer from, Integer to, List<Integer> excludedDigits) {
        List<String> result = IntStream.range(from, to)
                .mapToObj(number ->  {
                    String s = excludedDigits.stream()
                            .filter(excludedDigit -> number % excludedDigit == 0)
                            .map(digitWordMap::get)
                            .collect(Collectors.joining());
                    if (StringUtils.isEmpty(s)) {
                        return String.valueOf(number);
                    }
                    return s;
                }).collect(Collectors.toList());

        return result;
    }
}
