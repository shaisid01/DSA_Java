/* 3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

/*
Use a sliding window:
Expand the window (right pointer)
Shrink the window (left pointer) when duplicates appear

*/

package dsa.arrays;
import java.util.HashMap;

public class LongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            /*if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }*/

            if (map.getOrDefault(c, -1) >= left) {
                left = map.get(c) + 1;
            }

            map.put(c, right);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
