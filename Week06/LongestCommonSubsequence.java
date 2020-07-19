/**
 * @author ShiChang Wang
 * @description 最长公共子序列
 * @date 2020/7/19
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }

        int t1Len = text1.length();
        int t2Len = text2.length();

        int[][] result = new int[t1Len + 1][t2Len + 1];
        result[0][0] = 0;
        for (int i = 1; i <= t1Len; i++) {
            for (int j = 1; j <= t2Len; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j -1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }

        return result[t1Len][t2Len];



    }
}
