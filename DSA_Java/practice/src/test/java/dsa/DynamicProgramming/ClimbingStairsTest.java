package dsa.DynamicProgramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ClimbingStairsTest {

    
    @Test
    void testClimbStairs() {

        ClimbingStairs cs = new ClimbingStairs();

        assertEquals(1, cs.climbStairs(1));
        assertEquals(2, cs.climbStairs(2));
        assertEquals(3, cs.climbStairs(3));
        assertEquals(5, cs.climbStairs(4));
        assertEquals(8, cs.climbStairs(5));
    }

    @Test
    void testBaseCases() {

        ClimbingStairs cs = new ClimbingStairs();

        // Smallest valid inputs
        assertEquals(1, cs.climbStairs(1));
        assertEquals(2, cs.climbStairs(2));
    }

    @Test
    void testTypicalCases() {

        ClimbingStairs cs = new ClimbingStairs();

        assertEquals(3, cs.climbStairs(3));
        assertEquals(5, cs.climbStairs(4));
        assertEquals(8, cs.climbStairs(5));
        assertEquals(89, cs.climbStairs(10));
    }

    @Test
    void testLargeInput() {

        ClimbingStairs cs = new ClimbingStairs();

        // Checks performance and correctness for larger n
        assertEquals(1836311903, cs.climbStairs(45));
    }

    @Test
    void testZeroSteps() {

        ClimbingStairs cs = new ClimbingStairs();

        // Depending on implementation logic
        // current implementation returns 0
        assertEquals(0, cs.climbStairs(0));
    }

    @Test
    void testNegativeSteps() {

        ClimbingStairs cs = new ClimbingStairs();

        // current implementation returns negative input directly
        assertEquals(-1, cs.climbStairs(-1));
    }
}