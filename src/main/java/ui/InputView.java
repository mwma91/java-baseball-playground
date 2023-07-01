package ui;

import logic.ValidationUtils;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Integer> getPlayerNumbers() {
        boolean isValidInput = false;
        List<Integer> playerNumbers = null;
        while (!isValidInput) {
            pleaseEnterNumbers();
            playerNumbers = getPlayerInput();
            isValidInput = ValidationUtils.validateNumbers(playerNumbers);
            pleaseEnterValidNumbers(isValidInput);
        }

        return playerNumbers;
    }

    private static void pleaseEnterNumbers() {
        System.out.println("숫자를 입력해 주세요: ");
    }

    private static List<Integer> getPlayerInput() {
        int input = 0;
        try {
            input = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            return null;
        }

        return String.valueOf(input)
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void pleaseEnterValidNumbers(boolean isValidInput) {
        if (!isValidInput) {
            System.out.println("올바른 값이 아닙니다!");
        }
    }
}
