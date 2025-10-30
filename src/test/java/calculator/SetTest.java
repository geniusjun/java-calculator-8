package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
    }

    @Test
    @DisplayName("Set의 크기 테스트")
    void checkSize() {
        // given // when
        int size = numbers.size();
        // then
        Assertions.assertEquals(3, size);
    }

    @DisplayName("Set의 1, 2, 3의 값이 존재하는지를 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containNumber(int input) {
        assertThat(numbers.contains(input));
    }

    @DisplayName("Set에 값이 존재하면 true, 존재하지 않으면 false ")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false", "3:true", "4:true", "5:false"}, delimiter = ':')
    void containNumberBoolean(int input, Boolean excepted) {
        assertThat(numbers.contains(input)).isEqualTo(excepted);
    }

}
