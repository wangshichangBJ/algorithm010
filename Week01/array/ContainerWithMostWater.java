package array;

/**
 * @author ShiChang Wang
 * @description 盛的水最多的面积
 * @date 2020/7/7
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        // TO TEST
    }


    /**
     * 问题分析
     * 解题思路
     * 复杂度分析
     */
    class Solution {
        /**
         * 暴力解法，把每一个区间的面积求出，然后对比获取最大值
         * @param height
         * @return
         */
        public int maxArea1(int[] height) {
            int maxAreaValue = 0;
            int len = height.length;
            for(int i = 0; i < len; i++){
                for(int j = i + 1; j < len; j++) {
                    //获取两个柱子的小值
                    int h = Math.min(height[i], height[j]);
                    int newMaxArea = (j -i) * h;
                    //每次都将大的那个面积赋值给共享变量maxAreaValue
                    maxAreaValue = Math.max(maxAreaValue,newMaxArea);
                }
            }
            return maxAreaValue;
        }

        /**
         * 固定计算面积的一个参数(长或者宽)，然后使用双指针进行夹逼
         * @param height
         * @return
         */
        public int maxArea(int[] height) {
            int maxAreaValue = 0;
            int i = 0;
            int j = height.length - 1;
            for (; i < j;){
                int minheight = height[i] < height[j] ? height[i ++] : height[j--];
                int maxAreaTemp = (j -  i + 1) * minheight;
                maxAreaValue = Math.max(maxAreaTemp, maxAreaValue);
            }
            return maxAreaValue;
        }
    }
}
