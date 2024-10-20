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
  // implement
}

// ===== Memoization =====
class Memoize implements Solution {
  // implement
}

// ===== DP =====
class DP implements Solution {
  // implement
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
