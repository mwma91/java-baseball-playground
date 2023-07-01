package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomBallGenerator {
    public static List<Integer> generateRandomNumbers() {
        Random random = new Random(System.currentTimeMillis());
        int[] nineNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> randomNumbers = new ArrayList<>();

        int bound = nineNumbers.length;
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(bound);
            randomNumbers.add(nineNumbers[index]);
            swap(nineNumbers, index, bound);
            --bound;
        }

        return randomNumbers;
    }

    private static void swap(int[] array, int index1, int index2) {
        if ((index1 >= 0) && (index1 < array.length) && (index2 >= 0) && (index2 < array.length)) {
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }
}
