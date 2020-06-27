package queue;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,3,3,3,3,3,3,3,3,3};
        int[] ints = twoSum2(nums, 6);
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
    public static int[] twoSum1(int[] nums, int target) {
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

    /**
     * 思路：
     * 1、使用map集合的key存储target-数组nums[i]的结果，value存储第一个加数的下标i
     * 2、循环数组，当为第一个元素时，直接将第一个元素被target减过的结果和第一个元素的下标添加到put中
     *            当为第二个元素时，先判断第二个元素是否为target-第一个元素的结果。
     *                若是，则两个符合条件的元素对应的下标分别为map中key（nums[i]）为第二个元素的value和当前循环遍历的下标，返回；
     *                不是，则将target-第二个元素的结果作为key，第二个元素的下标作为value，插入到map集合中，执行下一次循环；
     * 3、直到获取符合条件的结果进行返回；
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            // 判断数组中是否有和target-nums[i]的结果相等的值，有的话就是这个值
            // 当前int数组中i位置的值与map中的对应i位置的key相等（target-nums[x] = nums[i]）
            if(map.containsKey(nums[i])){
                //说明此时i位置的值，是target-i之前任意下标位置的值的结果，则说明这个int说组中存在原下标索引对应的值+i下标索引对应的值
                //左边加数的索引为
                int left = map.get(nums[i]);
                //右边加数的索引为
                int right = i;
                return new int[] {left,right};
            }else{
                // 不相等，将这个结果添加到map中,key为target-nums[i]的结果，value第一个值的下标索引
                map.put(target-nums[i],Integer.valueOf(i));
            }
        }
        //没有结果返回空数组
        return new int[2];
    }


}
