/**
 * @author ShiChang Wang
 * @description 不同路径 DP解法
 * @date 2020/7/19
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m = 10 , n = 10;
        int total = up(m, n);
        System.out.println(total);
    }

    private static int up(int m, int n) {
        //先写边界条件
        if (m < 0 && n < 0){
            return 0;
        }
        int[][] result = new int[m][n];
        //定义第一行和第一列的走法都为1
        for (int i = 0; i < m ; i++) {
            result[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            result[0][j] = 1;
        }

        //遍历其他的点
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m-1][n-1];
    }
}
