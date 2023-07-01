package logic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    @DisplayName("난수 3개 생성")
    void generateRandomNumbers() {
        List<Integer> randomNumbers = RandomBallGenerator.generateRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("유효성 검사: 정상")
    void validate1() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3);
        assertThat(ValidationUtils.isValidNumbers(validNumbers)).isTrue();
        assertThat(ValidationUtils.isThreeDigits(validNumbers)).isTrue();
        assertThat(ValidationUtils.hasDuplicates(validNumbers)).isFalse();
    }

    @Test
    @DisplayName("유효성 검사: 숫자 범위 오류")
    void validate2() {
        List<Integer> invalidNumbers = Arrays.asList(0, 2, 10);
        assertThat(ValidationUtils.isValidNumbers(invalidNumbers)).isFalse();
        assertThat(ValidationUtils.isThreeDigits(invalidNumbers)).isTrue();
        assertThat(ValidationUtils.hasDuplicates(invalidNumbers)).isFalse();
    }

    @Test
    @DisplayName("유효성 검사: 숫자 개수 오류")
    void validate3() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2);
        assertThat(ValidationUtils.isValidNumbers(invalidNumbers)).isTrue();
        assertThat(ValidationUtils.isThreeDigits(invalidNumbers)).isFalse();
        assertThat(ValidationUtils.hasDuplicates(invalidNumbers)).isFalse();
    }

    @Test
    @DisplayName("유효성 검사: 숫자 중복 오류")
    void validate4() {
        List<Integer> invalidNumbers = Arrays.asList(1, 1, 2);
        assertThat(ValidationUtils.isValidNumbers(invalidNumbers)).isTrue();
        assertThat(ValidationUtils.isThreeDigits(invalidNumbers)).isTrue();
        assertThat(ValidationUtils.hasDuplicates(invalidNumbers)).isTrue();
    }
}
