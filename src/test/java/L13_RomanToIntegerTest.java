import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class L13_RomanToIntegerTest {

    private static Stream<Arguments> romanToIntegerArgumentsProvider() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("IV", 4),
                Arguments.of("VI", 6),
                Arguments.of("IX", 9),
                Arguments.of("XIX", 19),
                Arguments.of("", 0),
                Arguments.of("XLIX", 49),
                Arguments.of("XCVIII", 98),
                Arguments.of("CDXCIX", 499)
        );
    }

    @ParameterizedTest
    @MethodSource("romanToIntegerArgumentsProvider")
    public void testRomanToInteger(String s, int expectedResult) {

        int actualResult = new L13_RomanToInteger().romanToInt(s);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
