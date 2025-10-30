package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("1,2을 콤마(,)로 split 했을 때 1과 2로 잘 분리되는지 확인한다")
    public void splitCommaTest1() {
        // given
        String input = "1,2";

        // when// then
        Assertions.assertThat(input.split(",")).contains("1", "2");
    }

    @Test
    @DisplayName("1을 콤마(,)로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 테스트")
    public void splitCommaTest2() {
        // given
        String input = "1";
        // when // then
        Assertions.assertThat(input.split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 1,2를 반환하는 테스트")
    public void substringTest() {
        // given
        String input = "(1,2)";

        // when // then
        Assertions.assertThat(input.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
    void findOneCharacter() {
        // given
        String input = "abc";
        // when
        char character = input.charAt(1);
        // then
        Assertions.assertThat(character).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 에러 테스트")
    void findOneCharacterOrThrowException() {
        // given
        String input = "abc";
        // when // then
        Assertions.assertThatThrownBy(() -> {
            input.charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
