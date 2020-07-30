/**
 * @author ShiChang Wang
 * @description 翻转二进制位
 * @date 2020/7/30
 */
public class ReverseBits {
    public int reverseBits(int n) {
        //定义一个32位int值，用来存储翻转后的n
        int result = 0;
        //定义计数器，大于32就不在遍历n的二进制位
        int count = 0;
        while(count < 32) {
            //将result左移一位，用来放置n的最右位
            result <<= 1;
            //获取n的最右位
            int temp = n & 1;
            //将n的最右位放到result的最右位
            result |= temp;
            //将n的最右位移除
            n >>= 1;
            count++;
        }
        return result;
    }
}
