package gameobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    private Balls computerBalls;

    @BeforeEach
    void setup() {
        computerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void nothing() {
        assertThat(computerBalls.checkBallType(new Ball(1, 4))).isEqualTo(BallType.NOTHING);
    }

    @Test
    void ball() {
        assertThat(computerBalls.checkBallType(new Ball(2, 3))).isEqualTo(BallType.BALL);
    }

    @Test
    void strike() {
        assertThat(computerBalls.checkBallType(new Ball(1, 1))).isEqualTo(BallType.STRIKE);
    }
}
