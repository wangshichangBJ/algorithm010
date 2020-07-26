import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description N皇后
 * @date 2020/7/25
 */
public class SolveNQueens {
    /**
     * 定义列和主副对角线
     */
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        col = new boolean[n];
        // 对角线个数为 2 * n - 1
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];

        // 定义每行的元素个数
        List<Integer> row = new LinkedList<>();
        // 回溯寻找符合要求的每组解
        putQueen(n, 0, row);
        return ans;
    }

    private void putQueen(int n, int index, List<Integer> row) {
        // index 代表当前访问的行数,最多到 n; row 用来存放满足题意的一种情况
        // 如果遍历到了最后一行，即代表已经找出一组解出来
        if (index == n) {
            // 将找到的一组解转化为棋盘格的形式后再放入 ans
            ans.add(changeBoard(n, row));
            return;
        }
        // 遍历当前 index 行的所有位置(从前往后依次遍历)
        for (int i = 0; i < n; i++) {
            // index + i 表示横纵坐标相加
            // index - i + n - 1 表示横纵坐标之差
            // 如果当前位置元素与他同一列，同一主副对角线上没有重复元素
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                // 则该位置即皇后放置的位置，放入 row 存储位置信息，并标记为 true
                row.add(i);
                // 此时在该元素所在的列和主副对角线上就不能在遍历找到其他元素了
                // 即标记为 true
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                // 接着递归寻找下一行
                putQueen(n, index + 1, row);

                // 遍历完后再退出标记
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                // 回退上一格子(回溯)
                row.remove(row.size() - 1);
            }
        }
        return;
    }

    private List<String> changeBoard(int n, List<Integer> row) {
        // 将找到的一组解转化为棋盘格形式存储
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            // 初始化 ch 中所有位置元素为 ‘.’
            Arrays.fill(ch, '.');
            // 将 row 中已经确定下来的 Queen 位置改为 ‘Q’
            ch[row.get(i)] = 'Q';
            // 然后放入 tmp 中
            tmp.add(new String(ch));
        }
        return tmp;
    }

}
