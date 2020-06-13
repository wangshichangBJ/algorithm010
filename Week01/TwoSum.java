/**
 * 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int[] ints = twoSum(nums, 6);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 暴力解法
     * @param nums 数组
     * @param target 和
     * @return 指定数据的索引值
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i< nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target == (nums[i] + nums[j])) {
                    ints[0] = i;
                    ints[1] = j;
                }
            }
        }
        return ints;
    }


}
