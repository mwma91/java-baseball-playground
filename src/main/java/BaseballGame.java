import gameobject.Balls;
import logic.GameResult;
import logic.GameState;
import logic.RandomBallGenerator;
import ui.InputView;
import ui.ResultView;

public class BaseballGame {
    private static Balls answers;

    public static void main(String[] args) {
        GameState state = GameState.CONTINUE;
        answers = new Balls(RandomBallGenerator.generateRandomNumbers());

        while (state != GameState.EXIT) {
            setAnswers(state);
            GameResult result = answers.compare(InputView.getPlayerNumbers());
            state = ResultView.getResult(result);
        }
    }

    private static void setAnswers(GameState state) {
        if (state.isRestart()) {
            answers = new Balls(RandomBallGenerator.generateRandomNumbers());
            state = GameState.CONTINUE;
        }
    }
}
