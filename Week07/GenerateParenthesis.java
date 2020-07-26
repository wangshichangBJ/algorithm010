import java.util.ArrayList;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 括号生成
 * @date 2020/7/23
 */
public class GenerateParenthesis {

    /**
     * 深度优先
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        if (n < 0) {
            return result;
        }
        dfs("", 0, 0, n, result);
        return result;

    }

    private void dfs(String s, int left, int right, int n, ArrayList<String> result) {
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(s+"(", left + 1, right, n, result);
        }

        if (right < n) {
            dfs(s + ")", left, right + 1, n ,result);
        }
    }
}
