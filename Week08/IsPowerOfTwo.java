/**
 * @author ShiChang Wang
 * @description 2的幂
 * @date 2020/7/30
 */
public class IsPowerOfTwo {
    /**
     * n 与 （n-1） 若等于0 。说明n只有一个位是1，即n肯定是2的幂
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 &&  (n & (n - 1)) == 0;
    }
}
