package gameobject;

public enum BallType {
    STRIKE, BALL, NOTHING;

    public static boolean isNotNothing(BallType ballType) {
        return ballType != NOTHING;
    }

    public static boolean isStrike(BallType ballType) {
        return ballType == STRIKE;
    }

    public static boolean isBall(BallType ballType) {
        return ballType == BALL;
    }

    public static boolean isNothing(BallType ballType) {
        return ballType == NOTHING;
    }
}
