/**
 * @author ShiChang Wang
 * @description 盛最多水的容器（leetcode:11）
 * @date 2020/8/3 周一
 */
public class MaxArea {

    /**
     * 使用双指针的方法
     * 第一遍在此，第二遍在LeetCode
     * 计算两个柱子可以围起来的最大面积
     * @param height 每个柱子的高度
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        //定义双指针
        int i = 0;
        int len = height.length;
        int j = len - 1;

        //定义结果变量值，，初始化可盛水的数量为0
        int result = 0;
        while (i < j) {
            //头指针不会超过尾指针
            if (height[i] < height[j]) {
                //获取当前i指针和j指针圈起来的最大可盛水的面积
                //长为： j - i
                //高度为两个指针对应的最小高度（木桶原理）：height[i]
                result = Math.max(result, (j -i) * height[i]);

                //因为j位置的柱子高，所以不移动j,将i向右移动一位
                i++;
            } else {
                //获取当前i指针和j指针圈起来的最大可盛水的面积
                //长为： j - i
                //高度为两个指针对应的最小高度（木桶原理）：height[j]
                result = Math.max(result, (j - i) * height[j]);

                //因为i位置的柱子高，i不动。将j向左移动一位
                j--;
            }
        }
        return result;
    }

}
