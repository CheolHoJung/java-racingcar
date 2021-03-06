package adder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {

    private static final String DEFAULT_SEPARATOR = "[,:]";

    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";

    public static int add(String numbersWithSeparator) {
        if (isEmpty(numbersWithSeparator)) {
            return 0;
        }

        return calculate(parseInts(split(replace(numbersWithSeparator))));
    }

    private static String replace(String numbersWithSeparator) {
        return numbersWithSeparator.replaceAll(" ", "");
    }

    private static String[] split(String numbersWithSeparator) {
        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX);
        Matcher matcher = pattern.matcher(numbersWithSeparator);

        String numbers = matcher.matches() ? matcher.group(2) : numbersWithSeparator;
        String separator = matcher.matches() ? matcher.group(1) : DEFAULT_SEPARATOR;

        return numbers.split(separator);
    }

    private static int[] parseInts(String[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = parseInt(numbers[i]);
        }
        return result;
    }

    private static int parseInt(String number) {
        final int result = Integer.parseInt(number);
        if (result < 0) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    private static int calculate(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static boolean isEmpty(String target) {
        return target == null || target.isEmpty();
    }
}
