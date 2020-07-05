/**
 * @author ShiChang Wang
 * @description 搜索旋转排序数组
 * @date 2020/7/5
 */
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        // TO TEST
    }


    /**
     * 问题分析
     * 解题思路
     * 复杂度分析
     */
    class Solution {
        public int search(int[] nums, int target) {
            if (nums != null && nums.length > 0){
                //定义双指针，和中间值变量
                int lo = 0;
                int hi = nums.length - 1;
                int mid = 0;
                //遍历整个数组
                while (lo <= hi) {
                    //求中间值
                    mid = lo + (hi -lo) / 2;
                    if (target == nums[mid]){
                        //若中间值就是目标值，直接返回索引
                        return mid;
                    }

                    //先判断从初始值到mid的值是否为有序递增的，即左半段是否为有序递增的
                    if (nums[lo] <= nums[mid]){
                        //左半段有序递增
                        if (target >= nums[lo] && target < nums[mid]){
                            //数值在lo和mid之间
                            hi = mid - 1;
                        }else {
                            lo = mid + 1;
                        }
                    }else {
                        //右半段有序递增
                        if (target > nums[mid] && target <= nums[hi]){
                            //数值在mid和hi之间
                            lo = mid + 1;
                        }else {
                            hi = mid - 1;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
