package gameobject;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Integer> randomNumbers) {
        this.balls = createBalls(randomNumbers);
    }

    private static List<Ball> createBalls(List<Integer> randomNumbers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, randomNumbers.get(i)));
        }
        return balls;
    }

    public BallType checkBallType(Ball userBall) {
        return balls.stream()
                .map(ball -> ball.compare(userBall))
                .filter(BallType::isNotNothing)
                .findFirst()
                .orElse(BallType.NOTHING);
    }
}
