import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ShiChang Wang
 * @description 三数之和（leetcode:15）
 * 数组中三数相加等于0
 * @date 2020/8/4
 */
public class ThreeSum {
    /**
     * 使用双指针方法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int len = nums.length;
        //对数组进行排序,保证数据从小到大排序。如果第一个数都是大于0的，就不存在三数之和为0的值
        Arrays.sort(nums);
        //将数组从0开始遍历，直到len-2,获取三数中的第一个数
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                //如果第一个数都是大于0的，就不存在三数之和为0的值,跳出循环
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //如果当前元素和前一个元素相等时，由于上一个元素已经把所有的数据走了一遍，所以就不用重新再走一遍，跳过当前循环
                continue;
            }
            //确定另两个数的指针
            //第二个数指针从k的下一个值开始
            int j = i + 1;
            //第三个数的指针从尾巴开始
            int k = len - 1;

            while (j < k) {
                //保证两个指针在遇到的时候，该轮遍历就结束了
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    //和值大了，k指针向左移动，减小和的值。并在移动的过程中去除重复数据（重复数据只需要计算一遍就好，重复计算增加时间）
                    while (j < k && (nums[k] == nums[++k])) {
                    }
                }
                if (sum < 0) {
                    //和值小了，j指针向右移动，增大j指针对应的值，并去重
                    while (j < k && (nums[j] == nums[--j])) {
                    }
                }
                if (sum == 0) {
                    //找到了三数之和为0的值
                    ArrayList<Integer> sonResult = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                    result.add(sonResult);
                    //将j向右移动，计算下一个组合
                    while (j < k && (nums[j] == nums[--j])) {
                    }
                    //将k向左移动，计算下一个组合
                    while (j < k && (nums[k] == nums[++k])) {
                    }
                }
            }
        }
        return result;
    }
}
