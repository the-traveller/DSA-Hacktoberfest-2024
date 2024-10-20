/*
There is an array arr of heights of stone and Geek is standing at the first stone and
can jump to one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum
number of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the
stone to land on. Find the minimum possible total cost incurred before the Geek reaches
the last stone.

Example:

Input: k = 3, arr[]= [10, 30, 40, 50, 20]
Output: 30
Explanation: Geek will follow the path 1->2->5, the total cost would be | 10-30| + |30-20| = 30,
which is minimum
*/

import java.util.*;

interface Solution {
    public int ans(int[] arr, int k);
}

// ====== Recursion ======
class Recursion implements Solution {
    @Override
    public int ans(int[] arr, int k) {
        int n = arr.length;
        return frogKJump(arr, k, n-1);
    }
    private int frogKJump(int[] arr, int k, int n) {
        if(n == 0) return 0;
        int minEnergy = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++) {
            int curEnergy = (n-i >= 0) ? Math.abs(arr[n] - arr[n-i]) + frogKJump(arr, k, n-i) : Integer.MAX_VALUE;
            minEnergy = Math.min(curEnergy, minEnergy);
        }
        return minEnergy;
    }
}

// ====== Memoize =======
class Memoize implements Solution {
    @Override
    public int ans(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return frogKJump(arr, k, n-1, dp);
    }
    private int frogKJump(int[] arr, int k, int n, int[] dp) {
        if(n == 0) return 0;
        int minEnergy = Integer.MAX_VALUE;
        if(dp[n] != -1) return dp[n];
        for(int i=1; i<=k; i++) {
            int curEnergy = (n-i >= 0) ? Math.abs(arr[n] - arr[n-i]) + frogKJump(arr, k, n-i, dp) : Integer.MAX_VALUE;
            minEnergy = Math.min(curEnergy, minEnergy);
        }
        return dp[n] = minEnergy;
    }
}

// ====== DP =======
class DP implements Solution {
    @Override
    public int ans(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        return frogKJump(arr, k, n-1, dp);
    }
    private int frogKJump(int[] arr, int k, int n, int[] dp) {
        for(int j=1; j<=n; j++) {
            int minEnergy = Integer.MAX_VALUE;
            for(int i=1; i<=k; i++) {
                int curEnergy = (j-i >= 0) ? Math.abs(arr[j] - arr[j-i]) + dp[j-i] : Integer.MAX_VALUE;
                minEnergy = Math.min(curEnergy, minEnergy);
            }
            dp[j] = minEnergy;
        }
        return dp[n];
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 30, 40, 50, 20};
        int k = 3;
        int ans1 = new Recursion().ans(arr, k);
        System.out.printf("Recursion: %d%n", ans1);

        int ans2 = new Memoize().ans(arr, k);
        System.out.printf("Memoize: %d%n", ans2);

        int ans3 = new Memoize().ans(arr, k);
        System.out.printf("DP: %d%n", ans3);
    }
}
