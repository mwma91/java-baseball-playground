package baseball.gameobject;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class NumbersPair {
    private List<String> enteredNumbers;
    private List<String> randomNumbers;
}
