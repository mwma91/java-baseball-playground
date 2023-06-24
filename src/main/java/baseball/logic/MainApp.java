package baseball.logic;

import baseball.gameobject.NumbersPair;
import baseball.ui.InputView;
import baseball.ui.ResultView;

import java.util.List;

public class MainApp {
    private final GameResult gameResult = new GameResult();
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();
    private List<String> randomNumbers;
    private GameState currentState = GameState.START;

    public void updateGame() {
        // 저장된 결과 초기화
        gameResult.reset();

        // 난수생성
        if (currentState == GameState.START) {
            randomNumbers = GameLogic.getRandomNumbers();
            changeState(GameState.CONTINUIE);
        }

        // 사용자 입력
        Integer playerInput = inputView.getPlayerInput();

        // 입력받은 값 검증
        List<String> enteredNumbers = GameLogic.splitInputStringToList(playerInput);
        if (!GameLogic.isValidDigits(enteredNumbers)) {
            return;
        }

        NumbersPair numbersPair = NumbersPair.builder()
                .enteredNumbers(enteredNumbers)
                .randomNumbers(randomNumbers)
                .build();

        // 입력받은 값 비교하여 결과 계산
        GameLogic.calculateGameResult(gameResult, numbersPair);

        // 결과 출력
        GameState nextState = resultView.showResult(gameResult);
        if (nextState == GameState.RESTART) {
            nextState = inputView.restartOrNot();
        }
        changeState(nextState);
    }

    public boolean isGameOver() {
        return currentState == GameState.EXIT;
    }

    private void changeState(GameState nextState) {
        currentState = nextState;
    }

}
