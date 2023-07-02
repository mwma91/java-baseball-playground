package gameobject;

public enum BallType {
    STRIKE, BALL, NOTHING;

    public boolean isStrike(BallType ballType) {
        return ballType == STRIKE;
    }

    public boolean isBall(BallType ballType) {
        return ballType == BALL;
    }

    public boolean isNothing(BallType ballType) {
        return ballType == NOTHING;
    }
}
