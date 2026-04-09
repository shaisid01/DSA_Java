/* 
Longest Palindromic Substring
Given a string s, return the longest in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

*/

/*
A palindrome mirrors around its center. So,expand outward from each possible center.
For a string of length n, there are:

Odd length palindromes → center at i
Even length palindromes → center between i and i+1

Total centers = 2n - 1
A palindrome has a mirror property, which makes expanding from the center efficient.
use the expand-around-center approach. For each index, treat it as a center and expand outward for both odd and even length palindromes. 
keep track of the longest palindrome found so far.
Time: O(n²)
Space: O(1)

Alternative (Advanced)
Dynamic Programming → O(n²) time, O(n²) space
Manacher’s Algorithm → O(n) time
*/

package dsa.strings;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // odd length
            int len2 = expandFromCenter(s, i, i + 1);   // even length

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}