package gameobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class BallTest {
    private Ball ball;

    @BeforeEach
    void setup() {
        ball = new Ball(1, 5);
    }

    @Test
    @DisplayName("유효한 값을 가진 공")
    void validBall() {
        assertThat(ball.getPosition()).isBetween(1, 3);
        assertThat(ball.getNumber()).isBetween(1, 9);

        assertThatCode(() -> new Ball(0, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("position");

        assertThatCode(() -> new Ball(3, 10))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("number");
    }

    @Test
    void nothing() {
        assertThat(ball.compare(new Ball(1, 3))).isEqualTo(BallType.NOTHING);
    }


    @Test
    void strike() {
        assertThat(ball.compare(new Ball(1, 5))).isEqualTo(BallType.STRIKE);
    }

    @Test
    void ball() {
        assertThat(ball.compare(new Ball(2, 5))).isEqualTo(BallType.BALL);
    }

}
