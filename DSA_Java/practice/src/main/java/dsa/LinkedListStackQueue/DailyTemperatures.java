/*
Given an array of integers temperatures represents the daily temperatures, 
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. 
If there is no future day for which this is possible, keep answer[i] == 0 instead.
*/

/*

need to efficiently track the next greater element to the right, 
and stack helps maintain a decreasing sequence so we only process each element once.
For each day,

Next greater temperature to the right

So maintain a stack of indices where temperatures are:
decreasing from bottom → top

When we find a warmer day, we resolve previous days.

use a stack that stores indices, not values.

For each day i:

While current temp > temp at stack top:
pop index j
answer[j] = i - j
push i

Time	O(n)
Space	O(n)
*/
package dsa.LinkedListStackQueue;

import java.util.Stack;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
    }

    // Optional test run
    public static void main(String[] args) {
        int[] temps = {73, 74, 75, 71, 69, 72, 76, 73};

        int[] res = dailyTemperatures(temps);

        for (int r : res) {
            System.out.print(r + " ");
        }
    }
}
