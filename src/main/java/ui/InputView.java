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

    public static int getPlayerChoice() {
        boolean isValidInput = false;
        int playerChoice = 0;
        while (!isValidInput) {
            pleaseChooseToRestart();
            playerChoice = getPlayerChoiceInput();
            isValidInput = ValidationUtils.isValidCoice(playerChoice);
            pleaseEnterValidNumbers(isValidInput);
        }

        return playerChoice;
    }

    private static int getPlayerChoiceInput() {
        int input;
        try {
            input = Integer.parseInt(scanner.next());
        } catch (Exception e) {
            return 0;
        }

        return input;
    }

    private static void pleaseChooseToRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void pleaseEnterNumbers() {
        System.out.println("숫자를 입력해 주세요: ");
    }

    private static List<Integer> getPlayerInput() {
        int input;
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
