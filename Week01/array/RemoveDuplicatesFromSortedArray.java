package array;

/**
 * 删除排序数组中的重复项
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int i = removeDuplicates1(nums);
        System.out.println(i);
    }

    /**
     * 双指针
     * 第一版解法
     */
    public static int removeDuplicates1(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length){
            if (nums[i] == nums[j]){
                j++;
            }else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i+1;
    }

    /**
     * 双指针
     * 第二版优化
     */
    public static int removeDuplicates2(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length){
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }

    /**
     * 双指针
     * 第三版优化
     * @param nums
     * @return
     */
    public static int removeDuplicates3(int[] nums) {
        if (nums == null || nums.length <= 0){
            return 0;
        }

        int i = 0;
        int j = 1;
        while (j < nums.length){
            if (nums[i] != nums[j]){
                if (j - i > 1){
                    //优化复制机制
                    nums[ i + 1] = nums[j];
                }
                i++;
            }
            j++;
        }
        return i + 1;
    }
}
