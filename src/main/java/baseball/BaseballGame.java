package baseball;


import baseball.logic.MainApp;

public class BaseballGame {
    public static void main(String[] args) {
        MainApp mainApp = new MainApp();
        while (!mainApp.isGameOver()) {
            mainApp.updateGame();
        }
    }
}
