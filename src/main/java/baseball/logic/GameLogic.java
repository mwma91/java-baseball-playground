package baseball.logic;

import baseball.gameobject.NumbersPair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLogic {
    public static final int NUMBER_OF_DIGITS = 3;
    private static final Random random = new Random();

    public static List<String> getRandomNumbers() {
        random.setSeed(System.currentTimeMillis());
        List<String> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < NUMBER_OF_DIGITS) {
            String randomNumber = String.valueOf(random.nextInt(9) + 1);
            addNonDuplicateNumber(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    public static List<String> splitInputStringToList(int playerInput) {
        String inputString = String.valueOf(playerInput);
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            String enteredNumber = String.valueOf(inputString.charAt(i));
            addNonDuplicateNumber(numbers, enteredNumber);
        }
        return numbers;
    }

    public static boolean isValidDigits(List<String> enteredNumbers) {
        if (enteredNumbers.size() == NUMBER_OF_DIGITS) {
            return true;
        }
        System.out.println("중복 없는 3자리 수를 입력하여 주십시오.");
        return false;
    }

    public static void calculateGameResult(GameResult gameResult, NumbersPair numbersPair) {
        List<String> enteredNumbers = numbersPair.getEnteredNumbers();
        List<String> randomNumbers = numbersPair.getRandomNumbers();

        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            String enteredNumber = enteredNumbers.get(i);
            CallType callType = isStrikeOrBall(randomNumbers, i, enteredNumber);
            gameResult.addCallCount(callType);
        }
    }

    private static void addNonDuplicateNumber(List<String> numbers, String newNumber) {
        if (!numbers.contains(newNumber)) {
            numbers.add(newNumber);
        }
    }

    private static CallType isStrikeOrBall(List<String> randomNumbers, int index, String enteredNumber) {
        CallType callType = isStrike(randomNumbers.get(index), enteredNumber);
        if (callType.equals(CallType.NOTHING)) {
            callType = isBall(randomNumbers, enteredNumber);
        }

        return callType;
    }

    private static CallType isStrike(String randomNumber, String enteredNumber) {
        if (randomNumber.equals(enteredNumber)) {
            return CallType.STRIKE;
        }
        return CallType.NOTHING;
    }

    private static CallType isBall(List<String> randomNumbers, String enteredNumber) {
        if (randomNumbers.contains(enteredNumber)) {
            return CallType.BALL;
        }
        return CallType.NOTHING;
    }

}
