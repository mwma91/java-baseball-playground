import logic.RandomBallGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBallTest {
    @Test
    @DisplayName("중복 없는 난수 3개 생성")
    void generateRandomNumbers() {
        List<Integer> randomNumbers = RandomBallGenerator.generateRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(3);

        boolean hasDuplicates = randomNumbers.stream()
                .distinct()
                .count() != randomNumbers.size();
        assertThat(hasDuplicates).isFalse();
    }
}
