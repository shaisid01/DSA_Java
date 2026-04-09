/*Group Anagrams
Given an array of strings strs, group the together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]
*/

/*
To check if two strings are anagrams, they must contain the same characters with the same frequency. 
One simple way to verify this is to sort both strings and compare them.
convert both strings into character arrays, sort them, and then compare the sorted arrays.
Sorting each string takes O(k log k), and we do this for both strings, so the total time complexity is O(k log k).
The space complexity is O(k) due to the character arrays.
HashMap + Sorted Key
time O(n * k log k) and space complexity = O(n.k)
However, this is not the most optimal solution. We can improve the time complexity to O(k) 
using a frequency count array, which avoids sorting
*/

package dsa.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars); // sort characters
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(input));
    }
}