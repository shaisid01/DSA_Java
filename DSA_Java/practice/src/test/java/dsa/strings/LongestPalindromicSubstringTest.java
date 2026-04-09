package dsa.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class LongestPalindromicSubstringTest {

    private final LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

    @Test
    void testBasicPalindrome() {
        String input = "babad";
        String result = solution.longestPalindrome(input);

        assertTrue(result.equals("bab") || result.equals("aba"));
    }

    @Test
    void testEvenLengthPalindrome() {
        String input = "cbbd";
        String result = solution.longestPalindrome(input);

        assertEquals("bb", result);
    }

    @Test
    void testSingleCharacter() {
        String input = "a";
        String result = solution.longestPalindrome(input);

        assertEquals("a", result);
    }

    @Test
    void testEmptyString() {
        String input = "";
        String result = solution.longestPalindrome(input);

        assertEquals("", result);
    }

    @Test
    void testNoPalindromeLongerThanOne() {
        String input = "abc";
        String result = solution.longestPalindrome(input);

        assertTrue(result.length() == 1);
    }

    @Test
    void testEntireStringIsPalindrome() {
        String input = "racecar";
        String result = solution.longestPalindrome(input);

        assertEquals("racecar", result);
    }
}