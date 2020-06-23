import java.util.HashMap;
import java.util.Map;

/**
 * @author ShiChang Wang
 * @description 爬楼梯
 * @date 2020/6/23
 */
public class ClimbingStairs {
    // TO TEST
    public static void main(String[] args) {
        int n = 100;
        long i = climbingStairs1(n);
        System.out.println(i);
    }

    /**
     * 递归 + 缓存
     * 分析:
     * 1、爬楼梯，一次只能爬1层或者2层台阶
     * 2、怎么走？是先走1还是先走2，不确定，这个是具有随机性的
     * 3、所以想要爬到第n层台阶，需要走k个1和l个2。k + 2l = n，函数定义为f(n) = f(k) + f(l);
     *
     * 思路:找最近的 重复 子问题
     * 1、一定要使用逆序思维去推理。正向思维情况太多。逆序思维只有两种情况，即第2点。不论到哪一级台阶，都只有这两种情况；
     * 2、要想爬到第n层台阶，那么在n的上一步会有两种情况：n的上一步的台阶层数为n-1(走了一层)，或者n-2(走了2层)；
     * 3、即递推公式为f(n) = f(n-1) + f(n-2)。例如走到第3层台阶，第一步是走1层，下一步走2层，或者第一步走2层，第二步走1层；
     *
     * 复杂度分析
     *
     */
    public static Long climbingStairs1(int n){
        //递归一、跳出递归的条件定义, 递归二、当前层的逻辑处理
        if (n == 1){
            return 1L;
        }
        if (n == 2){
            return 2L;
        }
        Map<Integer, Long> cacheMap = new HashMap<>();
        if (cacheMap.get(n) == null){
            //递归三、跳到下一级递归
            cacheMap.put(n,climbingStairs1(n-1)+climbingStairs1(n-2));
        }
        return cacheMap.get(n);
    }

    /**
     * 动态规划
     * @param n 台阶数
     * @return
     */
    public static int climbingStairs2(int n){
        int[] results = new int[n+1];
        results[0]=1;
        results[1]=1;
        for (int i = 2; i <= n; i++){
            results[i] = results[i-1] + results[i-2];
        }
        return results[n];
    }
}
