package dsa.LinkedListStackQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class DailyTemperaturesTest {

    @Test
    void testExampleCase() {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};

        assertArrayEquals(expected, DailyTemperatures.dailyTemperatures(input));
    }

    @Test
    void testAllIncreasing() {
        int[] input = {60, 62, 65, 70};
        int[] expected = {1, 1, 1, 0};

        assertArrayEquals(expected, DailyTemperatures.dailyTemperatures(input));
    }

    @Test
    void testAllDecreasing() {
        int[] input = {80, 75, 70, 65};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, DailyTemperatures.dailyTemperatures(input));
    }

    @Test
    void testAllSameValues() {
        int[] input = {70, 70, 70, 70};
        int[] expected = {0, 0, 0, 0};

        assertArrayEquals(expected, DailyTemperatures.dailyTemperatures(input));
    }

    @Test
    void testSingleElement() {
        int[] input = {100};
        int[] expected = {0};

        assertArrayEquals(expected, DailyTemperatures.dailyTemperatures(input));
    }

    @Test
    void testMixedPattern() {
        int[] input = {30, 40, 35, 50, 45};
        int[] expected = {1, 2, 1, 0, 0};

        assertArrayEquals(expected, DailyTemperatures.dailyTemperatures(input));
    }
}