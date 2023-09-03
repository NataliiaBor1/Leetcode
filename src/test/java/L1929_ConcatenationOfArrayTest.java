import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class L1929_ConcatenationOfArrayTest {

    private static Stream<Arguments> ConcatenationOfArrayArgumentsProvider() {
        return Stream.of(
                Arguments.of(new int[] {1,2,1}, new int[] {1,2,1,1,2,1}),
                Arguments.of(new int[] {1,3,2,1}, new int[] {1,3,2,1,1,3,2,1}),
                Arguments.of(new int[] {1,1,1}, new int[] {1,1,1,1,1,1}),
                Arguments.of(new int[] {}, new int[] {}),
                Arguments.of(new int[] {-1,-3,-2,-1}, new int[] {-1,-3,-2,-1,-1,-3,-2,-1})
        );
    }

    @ParameterizedTest
    @MethodSource("ConcatenationOfArrayArgumentsProvider")
    public void testConcatenationOfArray(int[] nums, int[] expectedResult) {

        int[] actualResult = new L1929_ConcatenationOfArray().getConcatenation(nums);

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }


}
