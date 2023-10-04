import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class L27_RemoveElementTest {

    private static Stream<Arguments> removeElementsProvider() {
        return Stream.of(
                Arguments.of(new int[] {3,2,2,3}, 3, 2),
                Arguments.of(new int[] {0,1,2,2,3,0,4,2}, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("removeElementsProvider")
    public void testRemoveElements(int[] nums, int val, int expectedResult) {
        int actualResult = new L27_RemoveElement().removeElement(nums, val);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
