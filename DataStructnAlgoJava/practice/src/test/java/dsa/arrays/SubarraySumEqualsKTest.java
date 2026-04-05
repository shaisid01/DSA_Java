package dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SubarraySumEqualsKTest {

    @Test
    void testBasicCase() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {1, 1, 1};
        int k = 2;

        int result = solution.subarraySum(nums, k);

        assertEquals(2, result);
    }

    @Test
    void testWithNegativeNumbers() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {1, -1, 0};
        int k = 0;

        int result = solution.subarraySum(nums, k);

        assertEquals(3, result); // [1,-1], [0], [1,-1,0]
    }
    @Test
    void testSingleElement() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {5};
        int k = 5;

        int result = solution.subarraySum(nums, k);

        assertEquals(1, result);
    }
    @Test
    void testWholeArray() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {2, 3, 1};
        int k = 6;

        int result = solution.subarraySum(nums, k);

        assertEquals(1, result);
    }

    @Test
    void testOverlappingSubarrays() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {1, 2, 1, 2, 1};
        int k = 3;

        int result = solution.subarraySum(nums, k);

        assertEquals(4, result);
    }

    @Test
    void testAllZeros() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {0, 0, 0};
        int k = 0;

        int result = solution.subarraySum(nums, k);

        assertEquals(6, result);
    }

    @Test
    void testNoMatch() {
        SubarraySumEqualsK solution = new SubarraySumEqualsK();

        int[] nums = {1, 2, 3};
        int k = 7;

        int result = solution.subarraySum(nums, k);

        assertEquals(0, result);
    }
}