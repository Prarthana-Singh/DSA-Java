class Solution {
    public int maxMoves(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = 1;

        for (int j = n - 2; j >= 0; j--) {
            for (int i = m - 1; i >= 0; i--) {
                int localMax = 0;
                if (i - 1 >= 0 && j + 1 < n && grid[i][j] < grid[i - 1][j + 1])
                    localMax = Math.max(localMax, dp[i - 1][j + 1]);

                if (j + 1 < n && grid[i][j] < grid[i][j + 1])
                    localMax = Math.max(localMax, dp[i][j + 1]);

                if (i + 1 < m && j + 1 < n && grid[i][j] < grid[i + 1][j + 1])
                    localMax = Math.max(localMax, dp[i + 1][j + 1]);

                dp[i][j] += localMax;
            }
        }

        int max = 0;
        for (int[] row : dp)
            max = Math.max(max, row[0]);

        return max - 1;
    }
}
