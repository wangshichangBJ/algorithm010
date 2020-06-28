import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ShiChang Wang
 * @description 组合
 * @date 2020/6/28
 */
public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
        // TO TEST
        List<List<Integer>> combine = solution.combine(10, 4);
        for (List<Integer> integers : combine) {
            System.out.println(integers.toString());
        }
    }


    /**
     * 问题分析
     * 1、这是一个求排列组合的题目，从1-n个数中获取k个数的排列组合
     * 2、只能从小到大（前一个值小于后一个值），即保证不会重复
     * 3、使用回溯的方法，其他的执行递归：
     *      1）先拿出第一个数，然后循环递归其他的数进行组合，直到循环结束，回到上一个循环？
     *      2）从第二个数开始循环，重复第一步。直到结束为止
     * 解题思路
     * 复杂度分析
     */
    class Solution {
        List<List<Integer>> results = new ArrayList<>();
        public List<List<Integer>> combine(int n, int k) {
            Stack<Integer> result = new Stack<>();
            if (n <= 0 || k <= 0 || n< k){
                return results;
            }
            _findCombinations(1,n,k,result);
            return results;
        }

        private void _findCombinations(int begin, int n, int k, Stack<Integer> result) {
            if (result.size() == k){
                //满足了k个数的条件
                results.add(new ArrayList<Integer>(result));
                //递归中返回上一层，结束后返回方法调用
                return;
            }

            for (int i = begin; i <= n; i++){
                //将头数据添加到栈中
                result.add(i);
                //递归添加其他和1组合的数据
                _findCombinations(i+1,n,k,result);
                //在递归的过程中满足k个数的条件后，弹出栈顶的元素
                result.pop();
            }
        }
    }
}
