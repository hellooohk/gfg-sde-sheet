import java.util.*;

public class LCS {

    /*
     * Given two sequences, find the length of longest subsequence present in both
     * of them. Both the strings are of uppercase.
     */
    /*
     * LCS Recursive
     * private static int lcs(int x, int y, String s1, String s2)
     * {
     * if(x == 0 || y == 0) return 0;
     * if(s1.charAt(x-1) == s2.charAt(y-1)){
     * return lcs(x-1,y-1,s1,s2) + 1;
     * }
     * return Math.max(lcs(x-1,y,s1,s2),lcs(x,y-1,s1,s2));
     * 
     * }
     */
    private static int memoLcs(int x, int y, String s1, String s2, int[][] memo) {

        if (x == 0 || y == 0)
            return memo[x][y] = 0;
        if (memo[x][y] != -1) {
            return memo[x][y];
        }
        if (s1.charAt(x - 1) == s2.charAt(y - 1)) {
            memo[x][y] = memoLcs(x - 1, y - 1, s1, s2, memo) + 1;
            return memo[x][y];
        }
        memo[x][y] = Math.max(memoLcs(x - 1, y, s1, s2, memo), memoLcs(x, y - 1, s1, s2, memo));
        return memo[x][y];

    }

    private static int lcs(int x, int y, String s1, String s2) {
        int[][] memo = new int[x + 1][y + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        memoLcs(x, y, s1, s2, memo);
        return memo[x][y];
    }

    private static int bottomUpLCS(int x, int y, String s1, String s2) {
        int[][] cache = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 || j == 0) {
                    cache[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                } else {
                    cache[i][j] = Math.max(cache[i - 1][j], cache[i][j - 1]);
                }
            }
        }
        return cache[x][y];

    }

    public static void main(String[] args) {

    }
}
