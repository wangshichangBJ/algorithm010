import java.util.List;

/**
 * @author ShiChang Wang
 * @description 三角形最小路径和
 * @date 2020/7/19
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        //由于每行的子元素内部的元素个数与当前的行数相等
        int rowLen = triangle.size();
        int columnLen = triangle.size();
        int [][] result = new int[columnLen + 1][rowLen + 1];

        //从倒数第二行开始算
        for (int i = columnLen  - 1; i >= 0; i--) {
            //从子数组第一个开始算
            for (int j = 0; j <= i; j ++ ){
                result[i][j] = Math.min(result[i + 1][j], result[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return result[0][0];

    }
}
