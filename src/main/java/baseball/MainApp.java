package baseball;


import baseball.logic.GameResult;
import baseball.logic.GameState;

import java.util.*;

public class MainApp {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final GameResult GAME_RESULT = new GameResult();
    private static final int NUMBER_OF_DIGITS = 3;
    private static GameState currentState = GameState.START;
    private static List<String> randomNumbers;

    public static void main(String[] args) {
        while (currentState != GameState.EXIT) {
            updateGame();
        }
    }

    private static void updateGame() {
        GAME_RESULT.reset();

        // 난수생성
        if (currentState == GameState.START) {
            randomNumbers = getRandomNumbers();
            changeState(GameState.CONTINUIE);
        }

        // 사용자 입력
        Integer input = getInput();
        if (input == null) {
            return;
        }

        // 입력받은 값 검증
        List<String> enteredNumbers = splitToStrings(input);
        if (!isValidDigits(enteredNumbers)) {
            return;
        }

        // 입력받은 값 비교하여 결과 계산
        calculateGameResult(enteredNumbers);

        // 결과 출력
        handleResult();
    }

    private static void changeState(GameState nextState) {
        currentState = nextState;
    }

    private static Integer getInput() {
        System.out.println("숫자를 입력해 주세요 : ");
        int input;
        try {
            input = MainApp.SCANNER.nextInt();
        } catch (Exception e) {
            System.out.println("숫자만 입력하여 주십시오.");
            return null;
        }
        return input;
    }

    private static void calculateGameResult(List<String> enteredNumbers) {
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            String randomNumber = randomNumbers.get(i);
            String enteredNumber = enteredNumbers.get(i);
            checkCall(randomNumber, enteredNumber);
        }
    }

    private static void checkCall(String randomNumber, String enteredNumber) {
        if (isStrike(randomNumber, enteredNumber)) {
            GAME_RESULT.addStrikeCount();
            return;
        }

        if (isBall(enteredNumber)) {
            GAME_RESULT.addBallCount();
        }
    }

    private static boolean isStrike(String randomNumber, String enteredNumber) {
        return randomNumber.equals(enteredNumber);
    }

    private static boolean isBall(String enteredNumber) {
        return randomNumbers.contains(enteredNumber);
    }

    private static boolean isValidDigits(List<String> enteredNumbers) {
        if (enteredNumbers.size() == NUMBER_OF_DIGITS) {
            return true;
        }
        System.out.println("중복 없는 3자리 수를 입력하여 주십시오.");
        return false;
    }

    private static List<String> splitToStrings(int input) {
        String enteredNumbers = String.valueOf(input);
        List<String> inputNumbers = new ArrayList<>();
        for (int i = 0; i < enteredNumbers.length(); i++) {
            String enteredNumber = String.valueOf(enteredNumbers.charAt(i));
            addNonDuplicateNumbers(inputNumbers, enteredNumber);
        }
        return inputNumbers;
    }

    private static List<String> getRandomNumbers() {
        RANDOM.setSeed(System.currentTimeMillis());
        List<String> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_OF_DIGITS) {
            String randomNumber = String.valueOf(MainApp.RANDOM.nextInt(9) + 1);
            addNonDuplicateNumbers(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private static void addNonDuplicateNumbers(List<String> numbers, String newNumber) {
        if (!numbers.contains(newNumber)) {
            numbers.add(newNumber);
        }
    }

    private static void handleResult() {
        if (GAME_RESULT.getStrikeCount() == NUMBER_OF_DIGITS) {
            gameOver();
            return;
        }

        continueGame();
    }

    private static void gameOver() {
        System.out.println("3 스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        restartOrNot();
    }

    private static void restartOrNot() {
        Integer playerChoice;
        while (currentState == GameState.CONTINUIE) {
            playerChoice = getPlayerChoice();
            handlePlayerChoice(playerChoice);
        }
    }

    private static Integer getPlayerChoice() {
        try {
            return SCANNER.nextInt();
        } catch (Exception e) {
            System.out.println("숫자만 입력하여 주십시오.");
            return null;
        }
    }

    private static void handlePlayerChoice(Integer playerChoice) {
        if (playerChoice < 1 || playerChoice > 2) {
            System.out.println("1, 혹은 2를 입력하세요.");
            return;
        }

        if (playerChoice == 1) {
            changeState(GameState.START);
            return;
        }

        changeState(GameState.EXIT);
    }

    private static void continueGame() {
        if (GAME_RESULT.isNothing()) {
            System.out.println("Nothing.");
            return;
        }

        String result = "";
        if (GAME_RESULT.getBallCount() != 0) {
            result += GAME_RESULT.getBallCount() + "볼 ";
        }

        if (GAME_RESULT.getStrikeCount() != 0) {
            result += GAME_RESULT.getStrikeCount() + "스트라이크";
        }
        System.out.println(result);
    }
}
