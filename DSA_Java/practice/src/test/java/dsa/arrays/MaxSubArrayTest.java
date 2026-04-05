package dsa.arrays;

import com.sun.tools.javac.Main;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSubArrayTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
            Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
            Arguments.of(new int[]{1}, 1),
            Arguments.of(new int[]{5, 4, 3, 2, 1}, 15),
            Arguments.of(new int[]{-5, -2, -8, -1}, -1),
            Arguments.of(new int[]{0, -3, 5, -2, 1}, 5),
            Arguments.of(new int[]{2, -1, 2, 3, 4, -5}, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testMaxSubArray(int[] nums, int expected) {
        MaxSubArray obj = new MaxSubArray();
        assertEquals(expected, obj.maxSubArray(nums));
    }
}