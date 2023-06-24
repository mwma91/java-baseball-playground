package baseball.ui;

import baseball.logic.GameState;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public Integer getPlayerInput() {
        Integer playerInput = null;
        while (playerInput == null) {
            playerInput = scanPlayerInput();
        }
        return playerInput;
    }

    public GameState restartOrNot() {
        Integer playerChoice;
        GameState nextState = null;
        while (nextState == null) {
            playerChoice = getPlayerChoice();
            nextState = handlePlayerChoice(playerChoice);
        }
        return nextState;
    }

    private Integer getPlayerChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("숫자만 입력하여 주십시오.");
            return null;
        }
    }

    private static GameState handlePlayerChoice(Integer playerChoice) {
        if (playerChoice == null) {
            return null;
        }

        if (playerChoice < 1 || playerChoice > 2) {
            System.out.println("1, 혹은 2를 입력하세요.");
            return null;
        }

        if (playerChoice == 2) {
            return GameState.EXIT;
        }

        return GameState.START;
    }

    private Integer scanPlayerInput() {
        showInputPrompt();
        int input;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            showWarningPrompt();
            return null;
        }
        return input;
    }

    private void showInputPrompt() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    private void showWarningPrompt() {
        System.out.println("숫자만 입력하여 주십시오.");
    }
}
