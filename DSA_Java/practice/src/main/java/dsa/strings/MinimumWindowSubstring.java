/*
Minimum Window Substring
Hard
Topics
premium lock iconCompanies
Hint

Given two strings s and t of lengths m and n respectively, return the minimum window of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.

*/

/*
Count characters in t (what we need).
Use two pointers (left, right) to represent a window in s.
Expand right to include characters.
When the window satisfies all requirements, move left to shrink it.
Track the smallest valid window.

Algorithm Steps
Use a hashmap need → counts of characters in t
Maintain:
have → how many chars match required frequency
need_count → total unique chars in t
*/

package dsa.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();

        int have = 0;
        int needCount = need.size();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            // shrink window
            while (have == needCount) {
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) &&
                    window.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    // quick test
    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();

        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(obj.minWindow("a", "a")); // a
        System.out.println(obj.minWindow("a", "aa")); // ""
    }
}
