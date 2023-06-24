package baseball.ui;

import baseball.logic.GameResult;
import baseball.logic.GameState;

public class ResultView {
    public GameState showResult(GameResult gameResult) {
        GameState nextState = isGameOver(gameResult);
        if (nextState == GameState.RESTART) {
            return nextState;
        }

        nextState = isNothing(gameResult);
        if (nextState == GameState.CONTINUIE) {
            return nextState;
        }


        nextState = continueGame(gameResult);
        return nextState;
    }

    private GameState isNothing(GameResult gameResult) {
        if (!gameResult.isNothing()) {
            return null;
        }

        System.out.println("땡!");
        return GameState.CONTINUIE;
    }

    private GameState isGameOver(GameResult gameResult) {
        if (gameResult.getStrikeCount() != 3) {
            return null;
        }

        System.out.println("3 스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return GameState.RESTART;
    }

    private GameState continueGame(GameResult gameResult) {
        String result = "";
        if (gameResult.getBallCount() != 0) {
            result += gameResult.getBallCount() + "볼 ";
        }

        if ((gameResult.getStrikeCount() != 0)) {
            result += gameResult.getStrikeCount() + "스트라이크";
        }

        System.out.println(result);
        return GameState.CONTINUIE;
    }
}
