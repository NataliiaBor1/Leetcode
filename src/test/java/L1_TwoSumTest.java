import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class L1_TwoSumTest {

    @Test
    public void testTwoSumHappyPath() {
        //Arrange, Act, Assert
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expectedResult = {0, 1};

        int[] actualResult = new L1_TwoSum().twoSum(nums, target);

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    private static Stream<Arguments> twoSumArgumentsProvider() {
        return Stream.of(
                Arguments.of(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
                Arguments.of(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
                Arguments.of(new int[] {3, 3}, 6, new int[] {0, 1}),
                Arguments.of(new int[] {4, 5, 2, 7}, 9, new int[] {0, 1}),
                Arguments.of(new int[] {-4, 5, 2, 7}, 9, new int[] {2, 3}),
                Arguments.of(new int[] {}, 9, new int[] {-1, -1}),
                Arguments.of(new int[] {1}, 9, new int[] {-1, -1}),
                Arguments.of(new int[] {2, -7, -11, 15}, -18, new int[] {1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("twoSumArgumentsProvider")
    public void testTwoSum(int[] nums, int target, int[] expectedResult) {

        int[] actualResult = new L1_TwoSum().twoSum(nums, target);

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("twoSumArgumentsProvider")
    public void testTwoSum_HashMap(int[] nums, int target, int[] expectedResult) {

        int[] actualResult = new L1_TwoSum().twoSum_HashMap(nums, target);

        Assertions.assertArrayEquals(expectedResult, actualResult);
    }




}
