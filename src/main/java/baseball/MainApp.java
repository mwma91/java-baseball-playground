package baseball;


import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        // 난수생성
        Random random = new Random(System.currentTimeMillis());
        Set<String> randomNumbers = new LinkedHashSet<>();
        resetRandomNumbers(randomNumbers, random);

        // 사용자 입력
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("숫자를 입력해 주세요 : ");
            int temp;
            try {
                temp = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("숫자만 입력하여 주십시오.");
                continue;
            }
        }
    }

    private static void resetRandomNumbers(Set<String> randomNumbers, Random random) {
        while (randomNumbers.size() < 3) {
            randomNumbers.add(String.valueOf(random.nextInt(9) + 1));
        }
    }
}
