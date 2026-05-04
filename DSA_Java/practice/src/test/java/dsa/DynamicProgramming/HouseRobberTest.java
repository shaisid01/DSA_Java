package dsa.DynamicProgramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HouseRobberTest {

    @Test
    void testEmptyArray() {

        HouseRobber hr = new HouseRobber();

        assertEquals(0, hr.rob(new int[]{}));
    }

    @Test
    void testSingleHouse() {

        HouseRobber hr = new HouseRobber();

        assertEquals(5, hr.rob(new int[]{5}));
    }

    @Test
    void testTwoHouses() {

        HouseRobber hr = new HouseRobber();

        assertEquals(7, hr.rob(new int[]{2, 7}));
    }

    @Test
    void testExampleCases() {

        HouseRobber hr = new HouseRobber();

        assertEquals(4, hr.rob(new int[]{1, 2, 3, 1}));
        assertEquals(12, hr.rob(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    void testAlternateHouses() {

        HouseRobber hr = new HouseRobber();

        assertEquals(41, hr.rob(new int[]{6, 7, 1, 30, 8, 2, 4}));
    }

    @Test
    void testAllSameValues() {

        HouseRobber hr = new HouseRobber();

        assertEquals(10, hr.rob(new int[]{5, 5, 5, 5}));
    }

    @Test
    void testLargeValues() {

        HouseRobber hr = new HouseRobber();

        assertEquals(200, hr.rob(new int[]{100, 1, 1, 100}));
    }

    @Test
    void testNullArray() {

        HouseRobber hr = new HouseRobber();

        assertEquals(0, hr.rob(null));
    }
}