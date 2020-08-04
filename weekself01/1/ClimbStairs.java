/**
 * @author ShiChang Wang
 * @description 爬楼梯（leetcode:70）
 * @date 2020/8/3
 */
public class ClimbStairs {
    /**
     * 使用递归+缓存
     * f(n) = f(n -1) + f(n - 2);
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n < 2) {
            return n;
        }
        int[] cache = new int[n + 1];
        return climb(n,cache);
    }

    private int climb(int n, int[] cache) {
        cache[0] = 1;
        cache[1] = 1;
        if (cache[n] == 0){
            //缓存中没有n层楼梯的走法
            cache[n] = climb(n - 1, cache) + climb(n -2, cache);
        }
        return cache[n];
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n < 2) {
            return n;
        }
        int[] arr = new int[n + 1];
        //0层台阶，有一种跳法，即不跳；
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i -1] + arr[i -2];
        }
        return arr[n];
    }
}
