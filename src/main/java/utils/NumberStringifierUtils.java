package utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Класс для строкового форматирования чисел
 * @author Хисметов Радик
 */
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
        digitWordMap.put(8, "Eight");
        digitWordMap.put(9, "Nine");
    }

    /**
     * Метод переводит числа в строки из заданного диапазона. Если число кратно одному или нескольким числам из списка excludedDigits,
     * то числовое представление заменяется на конкатенацию строковых представлений кратных чисел
     * @param from начальное значение диапазона
     * @param to конечное значение диапазона
     * @param excludedDigits набор чисел для проверки на кратность. Ограничение: 1-9
     * @return возвращает список строковых представлений
     */
    public static List<String> stringifyRange(Integer from, Integer to, List<Integer> excludedDigits) {
        List<String> result = IntStream.range(from, to)
                .mapToObj(number ->  {
                    //если из списка excludedDigits найдутся числа(число), которым кратно number,
                    //то склеим их строковые представления
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
