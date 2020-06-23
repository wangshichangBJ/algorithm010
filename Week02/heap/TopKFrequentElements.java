package heap;

import java.util.*;

/**
 * @author ShiChang Wang
 * @description Top_k的解答（最小堆实现）
 * @date 2020/6/23
 */
public class TopKFrequentElements {
    // TO TEST
    public static void main(String[] args) {
        int[] a = new int[] {5,2,5,3,5,3,1,1,3};
        int k = 2;
        int[] ints = kFrequentElements1(a, k);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 分析
     * 1、在给定的数组中，计算每个元素出现的次数，最小肯定为1
     * 2、最后输出的是一个数组
     * 3、时间复杂度优于nlogn
     * 4、出现频次相等的元素怎么排序？？？
     *
     * 思路
     * 1、计算数组中每个元素出现的次数
     * 2、将每个元素出现的次数和对应的元素存储在哈希表中，以次数为key，元素值为value
     * 3、将每个元素出现的次数存储在大根堆（优先队列从大到小排列）
     * 4、从优先队列中取出前k个元素，然后从map中获取对应的元素值，并将获取到的元素值，填加到一个数组中返回
     *
     * 复杂度分析
     *
     */
    public static int[] kFrequentElements1(int[] nums, int k){
        //获取每个元素出现频次
        Map<Integer,Integer> firstMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (firstMap.containsKey(nums[i])){
                //以元素值为key，以频次为value，进行数据存储
                //map中已存在该元素，则将value值加1
                firstMap.put(nums[i],firstMap.get(nums[i])+1);
            }else {
                firstMap.put(nums[i],1);
            }
        }
        //将firstMap中添加到有序队列中(主要问题都是出现在排序规则上，一定要保证从小到大排序，这样每次poll数据时，才能保证根节点是最小值，并且被删除)
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> firstMap.get(n1) - firstMap.get(n2));
        //遍历map,将每个元素出现的频次从大到小存放到有序队列中
        for (int n: firstMap.keySet()) {
            //把数据添加到优先队列
            heap.add(n);
            if (heap.size() > k) {
                //当添加完数据，添加的 数据量已经超过了优先队列的定义容量k，删除小顶堆的根节点，把新加入的元素保留。以保证优先队列最后存储的数据都是从大到小的k个数据；
                heap.poll();
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            //将优先队列中的数据复制到List集合中，转移数据的同时删除该数据
            res.add(heap.remove());
        }
        //从小到大排序
        Collections.sort(res);
        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}
