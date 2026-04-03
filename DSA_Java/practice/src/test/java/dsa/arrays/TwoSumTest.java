package dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class TwoSumTest {

    @Test
    void testTwoSum() {
        TwoSum solution = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void testTwoSumCase2() {
        TwoSum solution = new TwoSum();

        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testTwoSumCase3() {
        TwoSum solution = new TwoSum();

        int[] nums = {3, 3};
        int target = 6;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test //test -ve numbers
    void testNegativeNumbers() {
        TwoSum solution = new TwoSum();

        int[] nums = {-3, 4, 3, 90};
        int target = 0;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{0, 2}, result);
    }

    @Test // test 0 values
    void testWithZero() {
        TwoSum solution = new TwoSum();

        int[] nums = {0, 4, 3, 0};
        int target = 0;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{0, 3}, result);
    }

    @Test
    void testSolutionLaterInArray() {
        TwoSum solution = new TwoSum();

        int[] nums = {1, 2, 3, 4, 6};
        int target = 10;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{3, 4}, result);
    }

    @Test
    void testLargeNumbers() {
        TwoSum solution = new TwoSum();

        int[] nums = {1000000, 500000, 500000};
        int target = 1000000;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{1, 2}, result);
    }

    @Test
    void testMinimumInput() {
        TwoSum solution = new TwoSum();

        int[] nums = {1, 5};
        int target = 6;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    void testMultipleSolutions() {
        TwoSum solution = new TwoSum();

        int[] nums = {1, 2, 3, 4};
        int target = 5;

        int[] result = solution.twoSum(nums, target);

        // Could be [0,3] OR [1,2]
        boolean valid =
            (result[0] == 0 && result[1] == 3) ||
            (result[0] == 1 && result[1] == 2);

        assert(valid);
    }

    @Test
    void testNoSolution() {
        TwoSum solution = new TwoSum();

        int[] nums = {1, 2, 3};
        int target = 7;

        int[] result = solution.twoSum(nums, target);

        assertArrayEquals(new int[]{}, result);
    }
}