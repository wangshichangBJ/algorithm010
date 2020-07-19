/**
 * @author ShiChang Wang
 * @description 最大子序列和
 * @date 2020/7/19
 */
public class MaxSubArray {
    public int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        //初始化一个最大值（默认第一个值最大）
        int maxVal = nums[0];
        //穷举所有的子序列，将每一个子序列的和都计算出来，然后比较大小
        //每一个元素都是单独的子序列，所以要len+1
        int[] result = new int[len + 1];
        result[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                result[i] = result[i - 1] + nums[i];
            } else {
                result[i] = nums[i];
            }
        }

        for (int j = 1; j < len; j++) {
            maxVal = Math.max(maxVal, result[j]);
        }
        return maxVal;
    }

    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        //初始化一个最大值（默认第一个值最大）
        int maxVal = nums[0];
        //穷举所有的子序列，将每一个子序列的和都计算出来，然后比较大小
        //每一个元素都是单独的子序列，所以要len+1
        int[] result = new int[len + 1];
        result[0] = nums[0];
        for (int i = 1; i < len; i++) {
                result[i] = Math.max(result[i - 1] + nums[i], nums[i]);
        }

        for (int j = 1; j < len; j++) {
            maxVal = Math.max(maxVal, result[j]);
        }
        return maxVal;
    }

    /**
     * O(n)  O(1)
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int maxVal = nums[0];
        int sum = 0;
        for (int i = 0 ; i < len; i++) {
            if (sum > 0){
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            maxVal = Math.max(sum,maxVal);
        }
        return maxVal;
    }
}
