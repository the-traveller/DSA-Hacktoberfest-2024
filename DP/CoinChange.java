class CoinChange {
    public int coinChange(int[] coins, int amount) {
        return minimumElements(coins, amount);
    }

    public static int minimumElements(int num[], int x) {
        // Write your code here..
        int[][] dp = new int[num.length][x+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = minCoinPick(dp, num, x, 0);

        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    public static int minCoinPick(int[][] dp, int[] coins, int target, int index) {
        if (target == 0) {
            return 0;
        }
        if (index == coins.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int take = Integer.MAX_VALUE;
        if (target - coins[index] >= 0) {
            take = minCoinPick(dp, coins, target - coins[index], index);
        }
        if (take != Integer.MAX_VALUE) {
            take++;
        }
        int notTake = minCoinPick(dp, coins, target, index+1);

        return dp[index][target] = Math.min(take, notTake);
    }
}
