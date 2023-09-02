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
                Arguments.of(61, false),
                Arguments.of(0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("happyNumberArgumentsProvider")
    public void testHappyNumber(int n, boolean expectedResult) {

        boolean actualResult = new L202_HappyNumber().isHappy1(n);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
