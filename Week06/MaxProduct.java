/**
 * @author ShiChang Wang
 * @description 乘积最大子数组
 * @date 2020/7/19
 */
public class MaxProduct {
    /**
     * 需要考虑负负得正 正负得负
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null | nums.length == 0) {
            return 0;
        }

        int len = nums.length;

        //需要添加一个维度，标识当前是正数还是负数(j=0为负数，j=1为正数)
        int[][] result = new int[len + 1][2];
        result[0][0] = nums[0];
        result[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                result[i][0] = Math.min(nums[i], nums[i] * result[i - 1][0]);
                result[i][1] = Math.max(nums[i], nums[i] * result[i - 1][1]);
            }  else {
                result[i][0] = Math.min(nums[i], nums[i] * result[i - 1][1]);
                result[i][1] = Math.max(nums[i], nums[i] * result[i - 1][0]);
            }
        }

        int maxResult = nums[0];
        for (int j = 1; j < len; j++ ) {
            maxResult = Math.max(maxResult, result[j][1]);
        }
        return maxResult;
    }
}
