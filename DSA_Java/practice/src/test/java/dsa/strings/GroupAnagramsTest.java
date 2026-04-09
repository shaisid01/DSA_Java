package dsa.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GroupAnagramsTest {

    @Test
    void testGroupAnagrams() {
        String[] input = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = GroupAnagrams.groupAnagrams(input);

        // Normalize result (sort inner lists and outer list)
        List<List<String>> normalized = normalize(result);

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("eat","tea","ate"),
                Arrays.asList("tan","nat"),
                Arrays.asList("bat")
        ));

        assertEquals(expected, normalized);
    }

    @Test 
    void edgeCases() {
        assertEquals(
            Collections.singletonList(Collections.singletonList("")),
            normalize(GroupAnagrams.groupAnagrams(new String[]{""}))
        );

        assertEquals(
            Collections.emptyList(),
            GroupAnagrams.groupAnagrams(new String[]{})
        );
    }

    @Test
    void singleWord() {
        String[] input = {"abc"};

        List<List<String>> result = normalize(GroupAnagrams.groupAnagrams(input));

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("abc")
        ));

        assertEquals(expected, result);
    }

    @Test
    void noAnagrams() {
        String[] input = {"abc", "def", "ghi"};

        List<List<String>> result = normalize(GroupAnagrams.groupAnagrams(input));

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("abc"),
                Arrays.asList("def"),
                Arrays.asList("ghi")
        ));

        assertEquals(expected, result);
    }

    @Test
    void allAnagrams() {
        String[] input = {"abc", "bca", "cab", "cba"};

        List<List<String>> result = normalize(GroupAnagrams.groupAnagrams(input));

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("abc", "bca", "cab", "cba")
        ));

        assertEquals(expected, result);
    }

    @Test
    void duplicates() {
        String[] input = {"eat", "tea", "eat"};

        List<List<String>> result = normalize(GroupAnagrams.groupAnagrams(input));

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("eat", "eat", "tea")
        ));

        assertEquals(expected, result);
    }

    @Test
    void mixedLengths() {
        String[] input = {"a", "ab", "ba", "abc", "cab"};

        List<List<String>> result = normalize(GroupAnagrams.groupAnagrams(input));

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("ab", "ba"),
                Arrays.asList("abc", "cab")
        ));

        assertEquals(expected, result);
    }

    @Test
    void caseSensitivity() {
        String[] input = {"Eat", "tea"};

        List<List<String>> result = normalize(GroupAnagrams.groupAnagrams(input));

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("Eat"),
                Arrays.asList("tea")
        ));

        assertEquals(expected, result);
    }

    @Test
    void multipleEmptyStrings() {
        String[] input = {"", "", ""};

        List<List<String>> result = normalize(GroupAnagrams.groupAnagrams(input));

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("", "", "")
        ));

        assertEquals(expected, result);
    }

    @Test
    void repeatedCharacters() {
        String[] input = {"aaa", "aaa", "aa"};

        List<List<String>> result = normalize(GroupAnagrams.groupAnagrams(input));

        List<List<String>> expected = normalize(Arrays.asList(
                Arrays.asList("aaa", "aaa"),
                Arrays.asList("aa")
        ));

        assertEquals(expected, result);
    }

    private List<List<String>> normalize(List<List<String>> list) {
        for (List<String> group : list) {
            Collections.sort(group);
        }
        list.sort(Comparator.comparing(a -> a.get(0)));
        return list;
    }
}
