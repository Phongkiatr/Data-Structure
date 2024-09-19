package solutions.pack7_Recursion;

public class GridPaths {
    public static int numberOfPaths(int [][] grid) {
        if (grid.length == 0)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = 1;

        // setup 1st row
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // setup 1st column
        for (int j = 1; j < dp[0].length; j++) {
            if (grid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // update dp
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]);
                }
            }
        }

        // return bottom-right
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
