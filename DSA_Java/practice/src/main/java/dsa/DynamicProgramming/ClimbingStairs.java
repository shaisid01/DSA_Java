/*You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */

 /*
 This problem follows the Fibonacci pattern:

To reach step n, you can:
come from (n - 1) by taking 1 step
come from (n - 2) by taking 2 steps

So:

f(n)=f(n−1)+f(n−2)

Time Complexity
O(n)
Space Complexity
O(1)
 */

package dsa.DynamicProgramming;

public class ClimbingStairs {

    // Dynamic Programming Approach
    public int climbStairs(int n) {

        // Base cases
        if (n <= 2) {
            return n;
        }

        int first = 1;   // ways to reach step 1
        int second = 2;  // ways to reach step 2

        // Calculate ways from step 3 to n
        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }

        return second;
    }

    public static void main(String[] args) {

        ClimbingStairs cs = new ClimbingStairs();

        System.out.println(cs.climbStairs(2)); // Output: 2
        System.out.println(cs.climbStairs(3)); // Output: 3
        System.out.println(cs.climbStairs(5)); // Output: 8
    }
}