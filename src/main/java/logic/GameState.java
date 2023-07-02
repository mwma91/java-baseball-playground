package logic;

public enum GameState {
    RESTART, EXIT, CONTINUE;

    public boolean isRestart() {
        return this == RESTART;
    }
}
