import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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
                Arguments.of("CDXCIX", 499),
                Arguments.of("DCXXI", 621),
                Arguments.of("YTMRU", 0),
                Arguments.of("YTRU", 0),
                Arguments.of("XXVII", 27),
                Arguments.of("I", 1),
                Arguments.of("II", 2),
                Arguments.of("MMMCMXCVIII", 3998),
                Arguments.of("MMMCMXCIX", 3999),
                Arguments.of("MMMCMXCIXMMMCMXCIXMMMCMXCIX", 0),
                Arguments.of("MCQIX", 0),
                Arguments.of("ZCIX", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("romanToIntegerArgumentsProvider")
    public void testRomanToInteger(String s, int expectedResult) {

        int actualResult = new L13_RomanToInteger().romanToInt(s);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("romanToIntegerArgumentsProvider")
    public void testRomanToInteger1(String s, int expectedResult) {

        int actualResult = new L13_RomanToInteger().romanToInt1(s);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("romanToIntegerArgumentsProvider")
    public void testRomanToInteger2(String s, int expectedResult) {

        int actualResult = new L13_RomanToInteger().romanToInt2(s);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
