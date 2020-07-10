package array;

/**
 * @author ShiChang Wang
 * @description 加1
 * @date 2020/7/10
 */
public class PlusOne {
    public static void main(String[] args) {
        Solution solution = new PlusOne().new Solution();
        // TO TEST
        int[] arr = new int[] {4,9,9};
        solution.plusOne1(arr);
    }


    /**
     * 问题分析
     * 解题思路
     * 复杂度分析
     */
    class Solution {
        public int[] plusOne1(int[] digits) {
            //获取当前数组的长度
            int len = digits.length;
            //从后向前遍历整个数组
            for (int i = len - 1; i >= 0; i-- ) {
                //对当前的数据进行加1操作
                digits[i]++;
                //对加1后的值对10取余，判断原来的数据是否为9，加1后变成了0，由于原数组中的数据不为0，所以取余得到0就说明原来的数据为9，需要进位，进入下一轮循环
                digits[i] %= 10;
                if (digits[i] != 0){
                    //说明原来的值不是9，即加1后不是0。不需要再进行循环，已完成加1，直接返回数组
                    return digits;
                }
            }
            //若上面循环完都没有return，说明数组的第一位也是9，还需要在向前进一位；则需要对数组进行扩1位，在下标为0的位置放值1（999 + 1 = 1000）
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;
        }

        /**
         * 递归写法
         * 只是对头部不为9，其他都为9的情况进行递归
         * @param digits
         * @return
         */
        //定义一个递归次数统计，用作跳出递归的条件
        int count = 0;
        public int[] plusOne2(int[] digits) {
            //定义当前列表的长度，每递归一次就将长度减1
            int len = digits.length - count++;
            //判断跳出条件
            if (digits[len -1] != 9){
                //最后一位不是9，直接执行价1操作
                digits[len - 1]++;
            }else {

                //最后一位是9，就进行递归不断的向前加1，直到遍历完整个数组
                while (len -1 > 0){
                    //将最后一位设置为0
                    digits[len - 1] = 0;
                    //进行递归运算
                    return plusOne2(digits);
                }

                //遍历完整个数组，第一位还是9.递归结束后，首位要在原来的基础上扩展1
                digits = new int[digits.length + 1];
                digits[0] = 1;
                return digits;
            }
            return digits;
        }

    }
}
