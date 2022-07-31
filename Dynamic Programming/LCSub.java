import java.util.*;

public class LCSub {
    /*
     * Given two strings. The task is to find the length of the longest common
     * substring.
     * Input: S1 = "ABCDGH", S2 = "ACDGHR", n = 6, m = 6
     * Output: 4
     * Explanation: The longest common substring
     * is "CDGH" which has length 4.
     */
    private static int ans;

    private static int longestCommonSubstr(String S1, String S2, int n, int m) {
        ans = -1;
        int[][] memo = new int[n + 1][m + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        longestCommonSubstrMemo(S1, S2, n, m, memo);
        return ans;

    }

    private static int longestCommonSubstrMemo(String S1, String S2, int n, int m, int[][] memo) {
        if (n == 0 || m == 0) {
            return memo[n][m] = 0;
        }
        if (memo[n][m] != -1)
            return memo[n][m];
        int include = 0;
        if (S1.charAt(n - 1) == S2.charAt(m - 1)) {
            include = longestCommonSubstrMemo(S1, S2, n - 1, m - 1, memo) + 1;
        }
        longestCommonSubstrMemo(S1, S2, n - 1, m, memo);
        longestCommonSubstrMemo(S1, S2, n, m - 1, memo);
        ans = Math.max(include, ans);
        return memo[n][m] = include;
    }

    private static int longestCommonSubstrBU(String S1, String S2, int n, int m) {
        int ans = -1;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (S1.charAt(n - 1) == S2.charAt(m - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }

        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
