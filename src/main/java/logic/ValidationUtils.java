package logic;

import java.util.List;

public class ValidationUtils {
    private static final int COUNT_OF_NUMBERS = 3;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    public static boolean isThreeDigits(List<Integer> numbers) {
        return numbers.size() == COUNT_OF_NUMBERS;
    }

    public static boolean isValidNumbers(List<Integer> numbers) {
        return numbers.stream()
                .noneMatch(n -> n > MAX_VALUE || n < MIN_VALUE);
    }

    public static boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != COUNT_OF_NUMBERS;
    }
}
