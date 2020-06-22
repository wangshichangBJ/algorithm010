package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author ShiChang Wang
 * @description 获取指定索引的丑数
 * @date 2020/6/22
 */
public class UglyNumber {
    // TO TEST
    public static void main(String[] args) {
        System.out.println(UglyNumber1(10));
    }

    /**
     * 分析
     * 1、丑数的概念：1235都是丑数，可以被1235整除的数也是丑数
     * 2、题意要求输出第n个丑数
     * 3、n不是无限大的（否则在运算时，内存会被打爆OOM）
     *
     * 思路
     * 1、定义一个堆将丑数保存在其中
     * 2、定义一个set集合，过滤重复的丑数
     * 3、定义一个数组，元素为2，3，5. 作为计算因子
     * 4、必须使用Long类型，int长度不满足
     * 复杂度分析
     *
     */
    public static int UglyNumber1(Integer index){
        //定义小于等于1690的丑数数组
        int[] results = new int[1690];
        //定义set集合，去除计算后重复的丑数
        Set<Long> set = new HashSet<>();
        //定义优先队列，用于每次获取优先队列中最小的丑数作为计算基数
        PriorityQueue<Long> queue = new PriorityQueue<>();
        //设定初始值(最小的第一个丑数)
        set.add(1L);
        queue.add(1L);
        //定义一个获取丑数的因子数组
        int[] factor = new int[] {2,3,5};
        for(int i = 0; i < results.length ; i++){
            //获取优先队列中当前最小的一个丑数
            Long minUglyNumInQueue = queue.poll();
            //将当前的最小丑数添加到丑数结果集中
            results[i] = minUglyNumInQueue.intValue();
            //根据因子数组，根据当前的丑数基数，计算下三个丑数
            for(int j = 0; j < factor.length; j++){
                Long newUglyNumByMinUglyNum = minUglyNumInQueue * factor[j];
                //判断被计算出的丑数是否已经出现过（set集合去重）
                if(!set.contains(newUglyNumByMinUglyNum)){
                    //没有出现过，将新计算出的丑数填加到set集合和优先队列中
                    set.add(newUglyNumByMinUglyNum);
                    queue.add(newUglyNumByMinUglyNum);
                }
            }
        }
        return results[index-1];
    }
}
