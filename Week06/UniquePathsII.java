/**
 * @author ShiChang Wang
 * @description 有障碍物的不同路径
 * @date 2020/7/19
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //处理边界条件
        if (obstacleGrid == null || obstacleGrid.length == 0 ) {
            return 0;
        }

        int columnLen = obstacleGrid.length;
        int rowLen = obstacleGrid[0].length;

        int[][] result = new int[columnLen][rowLen];

        //初始化第一行与第一列
        for (int i = 0; i < columnLen && obstacleGrid[i][0] == 0; i++) {
            result[i][0] = 1;
        }
        for (int j = 0; j < rowLen && obstacleGrid[0][j] == 0; j++) {
            result[0][j] = 1;
        }

        //遍历其它点
        for (int i = 1; i < columnLen; i++) {
            for (int j = 1; j < rowLen; j++) {
                if (obstacleGrid[i][j] == 0){
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result[columnLen - 1][rowLen - 1];

    }
}
