package baseball.logic;

import lombok.Getter;


@Getter
public class GameResult {
    private int ballCount;
    private int strikeCount;

    public void addBallCount() {
        ++ballCount;
    }

    public void addStrikeCount() {
        ++strikeCount;
    }

    public void reset() {
        ballCount = 0;
        strikeCount = 0;
    }

    public boolean isNothing() {
        return (ballCount == 0) && (strikeCount == 0);
    }
}
