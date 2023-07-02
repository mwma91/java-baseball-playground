package gameobject;

import lombok.Getter;

@Getter
public class Ball {
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        if (position < 1 || position > 3) {
            throw new IllegalArgumentException("position은 1 이상 3 이하여야 함!");
        }

        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("number는 1 이상 9 이하여야 함!");
        }

        this.position = position;
        this.number = number;
    }

    public BallType compare(Ball ball) {
        if (this.equals(ball)) {
            return BallType.STRIKE;
        }

        if (this.matchBallNumber(ball)) {
            return BallType.BALL;
        }

        return BallType.NOTHING;
    }

    public boolean matchBallNumber(Ball ball) {
        return this.number == ball.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;

        Ball ball = (Ball) o;

        if (position != ball.position) return false;
        return number == ball.number;
    }
}
