package dsa.strings;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ValidAnagramTest {

    @Test
    void validAnagrams() {
        assertTrue(ValidAnagram.isAnagram("anagram", "nagaram"));
        assertTrue(ValidAnagram.isAnagram("listen", "silent"));
        assertTrue(ValidAnagram.isAnagram("", ""));
    }

    @Test
    void invalidAnagrams() {
        assertFalse(ValidAnagram.isAnagram("rat", "car"));
        assertFalse(ValidAnagram.isAnagram("a", "b"));
        assertFalse(ValidAnagram.isAnagram("hello", "helloo"));
    }
}
