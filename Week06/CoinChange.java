/**
 * @author ShiChang Wang
 * @description 零钱兑换
 * @date 2020/7/19
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int len = amount + 1;
        int[] result = new int[len];

        result[0] = 0;

        for (int i = 1; i < len; i++) {
            //设置边界条件，如果超出，返回-1,兑换硬币的个数不允许超过Integer的最大值
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++) {
                if (i - coins[j] >= 0 && result[i - coins[j]] < min) {
                    min = result[i - coins[j]];
                }
            }
            result[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + 1));
        }
        return result[amount] == Integer.MAX_VALUE ? -1 : result[amount];

    }
}
