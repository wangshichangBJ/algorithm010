/**
 * @author ShiChang Wang
 * @description 斐波那契数列，DP解法
 * @date 2020/7/19
 */
public class Fibonacci {

    public static void main(String[] args) {
        int num = 30;
        int i = fibo(num);
        System.out.println(i);
    }

    private static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long[] result = new long[n +  1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i -1] + result[i - 2];
            result[i]=result[i]% 1000000007;
        }
        return (int)result[n];
    }


}
