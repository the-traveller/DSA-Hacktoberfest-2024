//problem link: https://leetcode.com/problems/minimum-falling-path-sum/
class MinFallingPathSum {
    
    public static int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1000);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(minPathSum(matrix, dp, 0, i), min);
        }
        return min;
    }

    public static int minPathSum(int[][] grid, int[][] dp, int row, int col) {
        if (row == dp.length) {
            return 0;
        }
        if (col < 0 || col >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[row][col] != -1000) {
            return dp[row][col];
        }

        return dp[row][col] = grid[row][col] + Math.min(minPathSum(grid, dp, row+1, col-1), Math.min(minPathSum(grid, dp, row+1, col),
                                                        minPathSum(grid, dp, row+1, col+1)));
    }
}
