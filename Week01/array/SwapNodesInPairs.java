package array;

/**
 * @author ShiChang Wang
 * @description 链表中交换相邻两个节点
 * @date 2020/7/8
 */
public class SwapNodesInPairs {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int _val){
            this.val = _val;
        }
    }

    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
        // TO TEST
        int i = 0;
        ListNode head = _productListNode(i, new ListNode(0));
        solution.swapPairs(head);
    }

    private static ListNode _productListNode(int i, ListNode head) {
        int[] arr = new int[]{1,2,3,4};
        //定义跳出递归的条件
        if (i > arr.length - 1){
            return head.next;
        }
        //处理当前层的逻辑
        ListNode listNode = new ListNode(arr[i]);
        head.next = listNode;
        //递归下探
        _productListNode(i+1, head.next);
        return head.next;
    }


    /**
     * 问题分析
     * 核心在于两两交换，在交换完成后再连接对面的
     * 解题思路
     * 1、先设置一个前置的节点pre，在进行两个节点交换时，用户解决索引的交换
     * 2、将pre节点的next节点设置为当前链表的第一个头结点head
     * 3、当前节点和当前节点的next节点都不为null
     * 复杂度分析
     */
    class Solution {
        /**
         * 迭代方法
         * @param head 链表
         * @return
         */
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }

            //根据当前的链表，定义一个前置链表
            ListNode newPreListNode = new ListNode(-1);
            newPreListNode.next = head;
            ListNode preNode = newPreListNode;
            while (head != null && head.next != null) {
                //定义临时变量
                //要交换的前面的节点
                ListNode firstNode = head;
                //要交换的后面的节点
                ListNode secondNode = head.next;

                //将前置节点指向second
                preNode.next = secondNode;
                //将first变量指向第二个节点的下一个节点
                firstNode.next = secondNode.next;
                //将第二个节点指向第一个节点实现交换位置
                secondNode.next = firstNode;

                //为下一组节点的交换做准备，重置pre节点和head节点
                preNode  = firstNode;
                head = firstNode.next;
            }
            //由于newPreListNode定义的是-1，从-1节点的洗衣歌节点算起，就是要的结果
            return newPreListNode.next;
        }

        /**
         * 递归
         * @param head
         * @return
         */
        public ListNode swapPairs1(ListNode head) {
            //跳出递归条件
            if (head == null || head.next == null) {
                return head;
            }
            //定义交换的两个节点,当前层的逻辑
            ListNode first = head;
            ListNode second = head.next;

            //交换后的指向
            first.next = swapPairs(second.next);
            second.next = first;

            return second;
        }
    }
}
