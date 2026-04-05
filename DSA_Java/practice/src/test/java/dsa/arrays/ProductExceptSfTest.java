package dsa.arrays;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProductExceptSfTest {

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
            // Basic case
            Arguments.of(
                new int[]{1, 2, 3, 4},
                new int[]{24, 12, 8, 6}
            ),

            // With zero
            Arguments.of(
                new int[]{-1, 1, 0, -3, 3},
                new int[]{0, 0, 9, 0, 0}
            ),

            // Single element
            Arguments.of(
                new int[]{5},
                new int[]{1}
            ),

            // Two elements
            Arguments.of(
                new int[]{2, 3},
                new int[]{3, 2}
            ),

            // Multiple zeros
            Arguments.of(
                new int[]{0, 0, 2},
                new int[]{0, 0, 0}
            ),

            // All negative numbers
            Arguments.of(
                new int[]{-2, -3, -4},
                new int[]{12, 8, 6}
            ),

            // Mix of positives and negatives
            Arguments.of(
                new int[]{-1, 2, -3, 4},
                new int[]{-24, 12, -8, 6}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testProductExceptSf(int[] nums, int[] expected) {
        ProductExceptSf obj = new ProductExceptSf();
        assertArrayEquals(expected, obj.productExceptSelf(nums));
    }
}