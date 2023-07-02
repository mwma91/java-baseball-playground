package logic;

import gameobject.BallType;
import lombok.Getter;

@Getter
public class GameResult {
    private int ballCount;
    private int strikeCount;

    public void add(BallType ballType) {
        if (ballType.isStrike()) {
            ++strikeCount;
        }

        if (ballType.isBall()) {
            ++ballCount;
        }
    }
}
