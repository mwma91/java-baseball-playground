package baseball.logic;

import lombok.Getter;


@Getter
public class GameResult {
    private int ballCount;
    private int strikeCount;

    public void addCallCount(CallType callType) {
        if (callType.equals(CallType.STRIKE)) {
            ++strikeCount;
            return;
        }

        if (callType.equals(CallType.BALL)) {
            ++ballCount;
        }
    }

    public void reset() {
        ballCount = 0;
        strikeCount = 0;
    }

    public boolean isNothing() {
        return (ballCount == 0) && (strikeCount == 0);
    }
}
