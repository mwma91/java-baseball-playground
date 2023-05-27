import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();
        String[] strings = values.split(" ");

        int sum = 0;
        int number = 0;
        String operator;

        for (int i = 0; i < strings.length; i++) {
            if (i % 2 == 0) {
                number = Integer.parseInt(strings[i]);
                System.out.println(number);
            }
            else {
                operator = strings[i];
                System.out.println(operator);
                sum = calculate(sum, operator, number);
            }
        }

        System.out.println(sum);
    }

    private static int calculate(int sum, String operator, int number) {
        switch (operator) {
            case "+" -> sum += number;
            case "-" -> sum -= number;
            case "*" -> sum *= number;
            case "/" -> sum /= number;
        }
        return sum;
    }
}
