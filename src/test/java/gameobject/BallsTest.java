package gameobject;

import logic.GameResult;
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

    @Test
    void strike3() {
        GameResult result = computerBalls.compare(Arrays.asList(1, 2, 3));
        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @Test
    void strike0_ball0() {
        GameResult result = computerBalls.compare(Arrays.asList(4, 5, 6));
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @Test
    void strike1_ball1() {
        GameResult result = computerBalls.compare(Arrays.asList(1, 3, 5));
        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(1);
    }

    @Test
    void ball3() {
        GameResult result = computerBalls.compare(Arrays.asList(2, 3, 1));
        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(3);
    }
}
