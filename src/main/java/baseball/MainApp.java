package baseball;


import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        // 난수생성
        Random random = new Random(System.currentTimeMillis());
        Set<String> randomNumbers = new LinkedHashSet<>();
        resetRandomNumbers(randomNumbers, random);
    }

    private static void resetRandomNumbers(Set<String> randomNumbers, Random random) {
        while (randomNumbers.size() < 3) {
            randomNumbers.add(String.valueOf(random.nextInt(9) + 1));
        }
    }
}
