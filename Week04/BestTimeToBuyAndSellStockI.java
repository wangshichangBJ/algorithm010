import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 买卖股票的最佳时机I
 * @date 2020/7/3
 */
public class BestTimeToBuyAndSellStockI {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockI().new Solution();
        // TO TEST
        int[] arr = new int[] {7,6,4,3,1};
        solution.maxProfit(arr);
    }


    /**
     * 问题分析 暴力遍历
     * 1、将数组中的数据进行排列组合，只能前面向后面排列
     * 2、计算两个排列组合的差值a，后值减去前值, 利用哈希表存储差值和对应两个计算数
     * 3、将差值进行大小比较，取出差值最大的那个，输出；
     * 解题思路
     * 复杂度分析
     */
    class Solution {
        public int maxProfit(int[] prices) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < prices.length - 1; i++){
                for (int j = i + 1; j < prices.length ; j++){
                    int diff = prices[j] - prices[i];
                    if (diff > 0) {
                        result.add(diff);
                    }
                }
            }
            if (result.size() > 0) {
                Collections.sort(result);
                Integer integer = result.get(result.size() - 1);
                return integer;
            }
            return 0;
        }
    }
}
