package baseball;


import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        // 난수생성
        Random random = new Random(System.currentTimeMillis());
        List<String> randomNumbers = new ArrayList<>();
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

            List<String> userNumbers = splitToStrings(temp);
            if (userNumbers.size() != 3) {
                System.out.println("중복 없는 3자리 수를 입력하여 주십시오.");
                continue;
            }

            int ballCount = 0;
            int strikeCount = 0;
            for (int i = 0; i < userNumbers.size(); i++) {
                if (randomNumbers.get(i).equals(userNumbers.get(i))) {
                    ++strikeCount;
                    continue;
                }
                if (randomNumbers.contains(userNumbers.get(i))) {
                    ++ballCount;
                }
            }

            if (strikeCount == 3) {
                System.out.println("3 스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                int restartOrNot;
                while (true) {
                    try {
                        restartOrNot = scanner.nextInt();
                        if (restartOrNot < 1 || restartOrNot > 2) {
                            System.out.println("1, 혹은 2를 입력하세요.");
                            continue;
                        }
                    } catch (Exception e) {
                        System.out.println("숫자만 입력하여 주십시오.");
                        continue;
                    }

                    if (restartOrNot == 2) {
                        return;
                    }

                    resetRandomNumbers(randomNumbers, random);
                    break;
                }
                continue;
            }

            String result = "";
            if (ballCount != 0) {
                result += ballCount + "볼 ";
            }

            if (strikeCount != 0) {
                result += strikeCount + "스트라이크";
            }

            System.out.println(result);
        }
    }

    private static List<String> splitToStrings(int temp) {
        String enteredList = String.valueOf(temp);
        List<String> inputNumbers = new ArrayList<>();
        for (int i = 0; i < enteredList.length(); i++) {
            String enteredNumber = String.valueOf(enteredList.charAt(i));
            if (!inputNumbers.contains(enteredNumber)) {
                inputNumbers.add(enteredNumber);
            }
        }
        return inputNumbers;
    }

    private static void resetRandomNumbers(List<String> randomNumbers, Random random) {
        while (randomNumbers.size() < 3) {
            String randomNumber = String.valueOf(random.nextInt(9) + 1);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
    }
}
