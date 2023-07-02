package gameobject;

import logic.GameResult;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(List<Integer> randomNumbers) {
        this.answers = createBalls(randomNumbers);
    }

    private static List<Ball> createBalls(List<Integer> randomNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, randomNumbers.get(i)));
        }
        return balls;
    }

    public BallType checkBallType(Ball userBall) {
        return answers.stream()
                .map(ball -> ball.compare(userBall))
                .filter(BallType::isNotNothing)
                .findFirst()
                .orElse(BallType.NOTHING);
    }

    public GameResult compare(List<Integer> balls) {
        Balls playerBalls = new Balls(balls);
        GameResult result = new GameResult();
        for (Ball answer : answers) {
            result.add(playerBalls.checkBallType(answer));
        }
        return result;
    }
}
