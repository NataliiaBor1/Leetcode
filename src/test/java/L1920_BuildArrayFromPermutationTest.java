import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class L1920_BuildArrayFromPermutationTest {

    private static Stream<Arguments> buildArrayFromPermutationArgumentsProvider() {
        return Stream.of(
              Arguments.of(new int[] {0, 2, 1, 5, 3, 4}, new int[] {0, 1, 2, 4, 5, 3}),
              Arguments.of(new int[] {5, 0, 1, 2, 3, 4}, new int[] {4, 5, 0, 1, 2, 3}),
              Arguments.of(new int[] {0}, new int[] {0}),
              Arguments.of(new int[] {}, new int[] {}),
              Arguments.of(new int[] {5, -100, 5, 3, 4, 5}, new int[] {}),
              Arguments.of(new int[] {5, 4, 3, 2, 1, 0}, new int[] {0, 1, 2, 3, 4, 5})
        );
    }

    @ParameterizedTest
    @MethodSource("buildArrayFromPermutationArgumentsProvider")
    public void testBuildArray(int[] nums, int[] expectedResult) {

        int[] actualResult = new L1920_BuildArrayFromPermutation().buildArray(nums);

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }
}
