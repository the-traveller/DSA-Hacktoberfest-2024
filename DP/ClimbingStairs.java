/*

You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

*/

import java.util.*;

interface Solution {
    public int ans(int n);
}

// ===== Recursion =====
class Recursion implements Solution {
  public int ans(int n) { return climbStairs(n); }

    private int climbStairs(int n) {
        if(n <= 1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

// ===== Memoization =====
class Memoize implements Solution {
  public int ans(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairs(n, dp);
    }

    private int climbStairs(int n, int[] dp) {
        if(n <= 1) return dp[n] = 1;
        if(dp[n] != -1) return dp[n];
        return dp[n] = climbStairs(n-1, dp) + climbStairs(n-2, dp);
    }
}

// ===== DP =====
class DP implements Solution {
  public int ans(int n) {
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        return climbStairs(n, dp);
    }

    private int climbStairs(int n, int[] dp) {
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int ans1 = new Recursion().ans(n);
        System.out.printf("Recursion %d: %d%n", n, ans1);

        int ans2 = new Memoize().ans(n);
        System.out.printf("Memoization %d: %d%n", n, ans2);

        int ans3 = new DP().ans(n);
        System.out.printf("DP %d: %d%n", n, ans3);
    }
}
