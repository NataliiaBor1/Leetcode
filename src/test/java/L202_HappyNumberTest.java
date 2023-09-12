import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class L202_HappyNumberTest {

    private static Stream<Arguments> happyNumberArgumentsProvider() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false),
                Arguments.of(1, true),
                Arguments.of(7, true),
                Arguments.of(4, false),
                Arguments.of(229, false),
                Arguments.of(0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("happyNumberArgumentsProvider")
    public void testHappyNumber1(int n, boolean expectedResult) {

        boolean actualResult = new L202_HappyNumber().isHappy1(n);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("happyNumberArgumentsProvider")
    public void testHappyNumber2(int n, boolean expectedResult) {

        boolean actualResult = new L202_HappyNumber().isHappy2(n);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("happyNumberArgumentsProvider")
    public void testHappyNumber3(int n, boolean expectedResult) {

        boolean actualResult = new L202_HappyNumber().isHappy3(n);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
