package dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LongestSubStrTest {

    @Test
    void testBasicCase() {
        LongestSubStr solution = new LongestSubStr();

        String s = "abcabcbb";

        int result = solution.lengthOfLongestSubstring(s);

        assertEquals(3, result);
    }

    @Test
    void testAllSameCharacters() {
        LongestSubStr solution = new LongestSubStr();

        String s = "bbbbb";

        int result = solution.lengthOfLongestSubstring(s);

        assertEquals(1, result);
    }

    @Test
    void testMixedCase() {
        LongestSubStr solution = new LongestSubStr();

        String s = "pwwkew";

        int result = solution.lengthOfLongestSubstring(s);

        assertEquals(3, result);
    }

    @Test
    void testEmptyString() {
        LongestSubStr solution = new LongestSubStr();

        String s = "";

        int result = solution.lengthOfLongestSubstring(s);

        assertEquals(0, result);
    }

    @Test
    void testSingleCharacter() {
        LongestSubStr solution = new LongestSubStr();

        String s = "a";

        int result = solution.lengthOfLongestSubstring(s);

        assertEquals(1, result);
    }

    @Test
    void testNoRepeats() {
        LongestSubStr solution = new LongestSubStr();

        String s = "abcdef";

        int result = solution.lengthOfLongestSubstring(s);

        assertEquals(6, result);
    }
}