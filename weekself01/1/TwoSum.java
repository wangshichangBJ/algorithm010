import java.util.HashMap;
import java.util.Map;

/**
 * @author ShiChang Wang
 * @description 两数之和（leetcode:1）
 * @date 2020/8/3
 */
public class TwoSum {
    /**
     * 使用map进行计算
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int tempVal = target - nums[j];
            if (map.containsKey(tempVal)) {
                return new int[] {map.get(tempVal), j};
            } else {
                map.put(nums[j], j);
            }
        }
        return new int[2];
    }
}
