package dsa.arrays;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ProductExceptSelfTest {

    static Stream<org.junit.jupiter.params.provider.Arguments> provideTestCases() {
        return Stream.of(
                org.junit.jupiter.params.provider.Arguments.of(
                        new int[]{1, 2, 3, 4},
                        new int[]{24, 12, 8, 6}
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        new int[]{-1, 1, 0, -3, 3},
                        new int[]{0, 0, 9, 0, 0}
                ),
                org.junit.jupiter.params.provider.Arguments.of(
                        new int[]{2, 3, 4},
                        new int[]{12, 8, 6}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testProductExceptSelf(int[] nums, int[] expected) {
        ProductExceptSelf obj = new ProductExceptSelf();

        int[] result = obj.productExceptSelf(nums);

        assertArrayEquals(expected, result);
    }
}

