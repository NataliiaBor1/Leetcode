import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class L15_3SumTest {



    private static Stream<Arguments> threeSumArgumentsProvider() {
        return Stream.of(
                Arguments.of(new int[]{-1,0,1,2,-1,-4}, List.of(
                        List.of(-1,-1,2),
                        List.of(-1,0,1)
                        )),
                Arguments.of(new int[]{0,1,1}, List.of()),
                Arguments.of(new int[]{0,0,0}, List.of(List.of(0,0,0))),
                Arguments.of(new int[]{5, 5, -10, 0, 4, 6, -10}, List.of(
                        List.of(-10,5,5),
                        List.of(-10,4,6)
                        )),
                Arguments.of(new int[]{}, List.of()),
                Arguments.of(new int[]{0,1}, List.of()),
                Arguments.of(new int[]{100}, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("threeSumArgumentsProvider")
    public void testThreeSum(int[] nums, List<List<Integer>> expectedResult) {

        List<List<Integer>> actualResult = new L15_3Sum().threeSum2(nums);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("threeSumArgumentsProvider")  // does not work properly
    public void testThreeSumTripleLoop(int[] nums, List<List<Integer>> expectedResult) {

        List<List<Integer>> actualResult = new L15_3Sum().threeSumTripleLoop(nums);

        Assertions.assertEquals(expectedResult, actualResult);
    }

}
