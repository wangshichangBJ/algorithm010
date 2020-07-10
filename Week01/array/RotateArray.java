package array;

/**
 * @author ShiChang Wang
 * @description 旋转数组
 * @date 2020/7/9
 */
public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new RotateArray().new Solution();
        // TO TEST
        int[] arr = new int[] {1,2,3,4,5,6,7};
        int k = 8;
        solution.rotate2(arr, k);
    }


    /**
     * 问题分析 将题想象成一个环即可，交换就是一直在跑圈
     * 1、暴力解法，将数组的元素全部进行交换
     * 2、若当前索引的位置加K以后超过了
     * 解题思路
     * 复杂度分析
     */
    class Solution {
        /**
         * 暴力解法
         * @param nums 数组
         * @param k 旋转的位数
         */
    public void rotate1(int[] nums, int k) {
        int temp , pre = 0;
        k = k % nums.length;
        for (int i = 0; i < k; i++){
            //获取当前的最后一个值
            pre = nums[nums.length - 1];
            //遍历数组中其他的值
            for (int j = 0; j < nums.length; j++) {
                //开始替换（数组的后K个数据，每个数据都要完整的走一遍整个数组）
                //将当前被替换的值取出
                temp = nums[j];
                //将最后一个位置的数据给当前位置
                nums[j] = pre;
                //将下一个替换的值赋值给pre
                pre = temp;
            }
        }
    }

        /**
         * 使用反转方法
         * 1、不考虑k，直接将整个数组反转；
         * 2、将前k个数进行局部反转
         * 3、将nums.length - k 个数进行局部反转
         * @param nums
         * @param k
         */
        public void rotate2(int[] nums, int k) {
            //中间过程跑了n个圈回到起点和第一次到起点是相通的，此步就是为了规避重复跑圈的问题
            k %= nums.length;
            //旋转整个数组
            revers(nums,0, nums.length-1);
            //旋转前k个数据
            revers(nums,0,k-1);
            //旋转后length-k的数组
            revers(nums,k,nums.length - 1);

        }

        private void revers(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }

        }
    }
}
