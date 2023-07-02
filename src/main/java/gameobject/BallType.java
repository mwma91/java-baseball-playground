package gameobject;

public enum BallType {
    STRIKE, BALL, NOTHING;

    public static boolean isNotNothing(BallType ballType) {
        return ballType != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
