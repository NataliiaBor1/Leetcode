import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class L2828_CheckIfStringIsAcronymOfWordsTest {

    private static Stream<Arguments> checkIfStringIsAcronymOfWordsArgumentsProvider() {
        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList("alice", "bob", "charlie")), "abc", true),
                Arguments.of(new ArrayList<>(Arrays.asList("never","gonna","give","up","on","you")), "ngguoy", true),
                Arguments.of(new ArrayList<>(Arrays.asList("an", "apple")), "a", false),
                Arguments.of(new ArrayList<>(Arrays.asList("cat", "bob", "alice")), "abc", false)
        );
    }


    @ParameterizedTest
    @MethodSource("checkIfStringIsAcronymOfWordsArgumentsProvider")
    public void testCheckIfStringIsAcronymOfWords(List<String> words, String s, boolean expectedResult) {

        boolean actualResult = new L2828_CheckIfStringIsAcronymOfWords().isAcronym(words, s);

        Assertions.assertEquals(expectedResult, actualResult);
    }
}
