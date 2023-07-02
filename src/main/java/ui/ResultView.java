package ui;

import logic.GameResult;
import logic.GameState;

public class ResultView {
    public static GameState getResult(GameResult result) {
        if (!result.isGameOver()) {
            printResult(result);
            return GameState.CONTINUE;
        }

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료!");
        int playerChoice = InputView.getPlayerChoice();
        if (playerChoice == 1) {
            return GameState.RESTART;
        }

        return GameState.EXIT;
    }

    private static void printResult(GameResult result) {
        if (result.getBallCount() > 0) {
            System.out.println(result.getBallCount() + "볼 ");
        }

        if (result.getStrikeCount() > 0) {
            System.out.println(result.getStrikeCount() + "스트라이크");
        }
    }
}
