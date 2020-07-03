/**
 * @author ShiChang Wang
 * @description 买卖股票的最佳时机II
 * @date 2020/7/3
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockII().new Solution();
        // TO TEST
        int[] arr = new int[] {7,6,4,3,1};
        solution.maxProfit(arr);
    }


    /**
     * 问题分析
     * 1、相对于I类只能交易一次，II类题不限制交易次数
     * 2、前提是只能先买了再卖，卖完以后才能再买
     * 解题思路
     * 1、如果一段时间的价格都是持续上涨的，那么肯定是在涨的起点购买，涨的终点卖出，收益最大，所以对于持续上涨的一天买一天卖，求和既是最大收益
     * 2、如果是下降的或者不变的，不进行累加（不降低收益）
     * 复杂度分析
     */
    class Solution {
        public int maxProfit(int[] prices) {
            int sum = 0;
            for (int i = 1; i < prices.length; i++) {
                int temp = prices[i] - prices[i - 1];
                if (temp > 0){
                    sum += temp;
                }
            }
            return sum;
        }
    }

}
