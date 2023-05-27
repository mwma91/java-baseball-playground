package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
    
    @Test
    @DisplayName("")
    void split() {
        // given
        String numbers = "1,2";
        // when
        var result = numbers.split(",");
        // then
        assertThat(result).contains("1").contains("2");
    }

    @Test
    @DisplayName("")
    void substring() {
        // given
        String numbers = "(1,2)";
        // when
        var result = numbers.substring(1, 4);
        // then
        assertThat(result).isEqualTo("1,2");
    }
    
    @Test
    @DisplayName("주어진 문자열의 길이보다 큰 값을 charAt() 메소드에 사용 시 IndexOutOfBoundsException 발생")
    void charAt() {
        // given
        String abc = "abc";
        // when
        var a = abc.charAt(0);
        // then
        assertThat(a).isEqualTo('a');
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            var d = abc.charAt(3);
        }).withMessageContaining("index");
    }
}
