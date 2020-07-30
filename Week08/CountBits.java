/**
 * @author ShiChang Wang
 * @description 统计比特位是1的个数
 * @date 2020/7/30
 */
public class CountBits {
    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 0;
        for(int i = 1; i <= num; i++) {
            if (i % 2 == 1) {
                //i是奇数，奇数总比前面的偶数会多一个1
                arr[i] = arr[i -1] + 1;
            } else {
                //i是偶数，偶数=2的n次幂，就有n个1，所以除以2取整就是偶数的二进制中1的个数
                arr[i] = arr[i / 2];
            }
        }
        return arr;
    }
}
