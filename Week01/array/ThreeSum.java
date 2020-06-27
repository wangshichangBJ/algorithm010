package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 三数之和
 * @date 2020/6/27
 */
public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] arr = {-1,0,1,2,-1,-4};
        solution.threeSum(arr);
    }


    /**
     * while (i < j && nums[i] == nums[++i]); while (i < j && nums[j] == nums[--j]); 没看懂怎么去重
     * 问题分析
     * 1、满足a + b + c = 0
     * 2、不重复的子集数组
     * 解题思路（https://leetcode-cn.com/problems/3sum/solution/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/）
     * 1、a + b + c = 0  可以转换成 a + b = -c
     * 2、只需要从数组中拿出2个数，然后求和为第三个数的负数即可
     * 3、去除重复的子集
     * 4、定义三个指针，分别表示a b c
     * 5、先对数组进行排序，保证数据从小到大的顺序
     * 复杂度分析
     *
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> results = new ArrayList<>();
            //循环c的值，c从下标k从0开始，c的最大长度为length-2，以保证a 和 b至少有值
            for (int k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) {
                    //在下标为0的数值，经过排序后，它为整个数组的最小值。若它的值大于0，则说明这个数组没有小于0的值，就不可能存在a + b < 0的情况存在；
                    break;
                }
                if (k > 0 && nums[k] == nums[k - 1]) {
                    //如果当前k位置的值与它左边的前一个值相同，那么在k-1位置计算和为-c的两个数时就已经计算完成了，当前k位置的-c就没有必要再计算一遍了，执行k+1
                    continue;
                }
                //定义a值的下标i和b值的下标j
                int i = k + 1;
                int j = nums.length - 1;
                //保证数组不会越界
                while (i < j) {
                    //sum为0
                    int sum = nums[k] + nums[i] + nums[j];
                    if (sum < 0) {
                        //a + b < -c，将i下标右移一位（i+1）,因为经过排序后，右移后的值会变大，就越接近-c
                        while (i < j && (nums[i] == nums[++i])){};
                    }
                    if (sum > 0) {
                        //a + b > -c，将j的下标左移（j-1）。因为进过排序后，左移后的值会变小，就越接近-c
                        while (i < j && (nums[j] == nums[--j])){};
                    }
                    if (sum == 0) {
                        //符合条件
                        List<Integer> result = new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j]));
                        results.add(result);
                        //去重
                        while (i < j && nums[i] == nums[++i]) ;
                        while (i < j && nums[j] == nums[--j]) ;
                    }
                }
            }
            return results;
        }
    }
}
