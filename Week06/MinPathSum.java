/**
 * @author ShiChang Wang
 * @description 最小路径和
 * @date 2020/7/19
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if (i ==0 && j == 0){
                    continue;
                }
                if(i == 0 && j != 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                }
                if (i != 0 && j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                }
                if (i != 0 && j != 0) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[m -1][n -1];
    }
}
