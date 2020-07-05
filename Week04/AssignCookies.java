import java.util.Arrays;

/**
 * @author ShiChang Wang
 * @description 分饼干
 * @date 2020/7/4
 */
public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();
        // TO TEST
    }


    /**
     * 问题分析
     * 尽可能的满足孩子的胃口值
     * 解题思路
     * 1、暴力破解
     * 复杂度分析
     */
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            int count = 0;
            Arrays.sort(g);
            Arrays.sort(s);
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for (int i : s) {
//            queue.add(i);
//        }
//        //外层循环遍历循环孩子的胃口
//        for (int i = 0; i < g.length; i++) {
//            for (Integer sj : queue) {
//                if (sj >= g[i]){
//                    count++;
//                    queue.remove(sj);
//                    break;
//                }
//            }
//        }
            int k = 0;
            while (g.length > count && s.length > k){
                if (g[count] <= s[k]){
                    //满足孩子的胃口
                    count++;
                }
                //不满足就用下个饼干对比
                k++;
            }
            return count;
        }
    }
}
