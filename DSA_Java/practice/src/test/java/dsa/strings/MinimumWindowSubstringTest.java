package dsa.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MinimumWindowSubstringTest {

    @Test
    void testMinWindow_basic() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertEquals("BANC", obj.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    void testMinWindow_singleCharMatch() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertEquals("a", obj.minWindow("a", "a"));
    }

    @Test
    void testMinWindow_noSolution() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertEquals("", obj.minWindow("a", "aa"));
    }

    @Test
    void testMinWindow_exactMatch() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertEquals("ABC", obj.minWindow("ABC", "ABC"));
    }

    @Test
    void testMinWindow_withDuplicates() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertEquals("AAB", obj.minWindow("AAABBB", "AAB"));
    }

    @Test
    void testMinWindow_caseSensitive() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertEquals("aA", obj.minWindow("aA", "Aa"));
    }

    @Test
    void testMinWindow_emptyStrings() {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        assertEquals("", obj.minWindow("", "ABC"));
        assertEquals("", obj.minWindow("ABC", ""));
    }
}
