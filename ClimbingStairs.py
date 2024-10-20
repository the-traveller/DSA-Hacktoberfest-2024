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


  class Solution:
    def ans(self, n):
        pass


class Recursion(Solution):
    def ans(self, n):
        return self.climb_stairs(n)

    def climb_stairs(self, n):
        if n <= 1:
            return 1
        return self.climb_stairs(n - 1) + self.climb_stairs(n - 2)


class Memoize(Solution):
    def ans(self, n):
        dp = [-1] * (n + 1)
        return self.climb_stairs(n, dp)

    def climb_stairs(self, n, dp):
        if n <= 1:
            return 1
        if dp[n] != -1:
            return dp[n]
        dp[n] = self.climb_stairs(n - 1, dp) + self.climb_stairs(n - 2, dp)
        return dp[n]


class DP(Solution):
    def ans(self, n):
        if n <= 1:
            return 1
        dp = [0] * (n + 1)
        dp[0], dp[1] = 1, 1
        for i in range(2, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]

if __name__ == "__main__":
    n = 3
    ans1 = Recursion().ans(n)
    print(f"Recursion {n}: {ans1}")

    ans2 = Memoize().ans(n)
    print(f"Memoization {n}: {ans2}")

    ans3 = DP().ans(n)
    print(f"DP {n}: {ans3}")
