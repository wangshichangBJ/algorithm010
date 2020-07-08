package array;

/**
 * @author ShiChang Wang
 * @description 反转链表
 * @date 2020/7/7
 */
public class ReverseLinkedList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int _val){
            this.val = _val;
        }
    }
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        // TO TEST
    }


    /**
     * 问题分析
     * 解题思路
     * 复杂度分析
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 使用双指针，来进行位置索引交换
         * @param head
         * @return
         */
        public ListNode reverseList1(ListNode head) {
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                ListNode temp = cur.next;
                cur.next = pre;
                //交换位置，将当前的cur置为下一轮的pre，t将当前的temp（cur.next）置为下一轮的cur
                pre = cur;
                cur = temp;
            }
            //最后的temp（cur）是最后一个节点的下一个节点null，所以pre为最后一个节点，将最后一个节点返回，即为反转后的链表
            return pre;
        }

        /**
         * 使用递归解决链表反转
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            //定义递归跳出的条件
            if (head == null || head.next == null) {
                return head;
            }

            //进入递归，获取所有的节点（每个节点都是它当前梦境的head）
            ListNode cur = reverseList(head.next);

            //处理当前层的逻辑
            //将当前梦境的head节点的next(下一层梦境节点head)的next设置为上一层梦境的head，将next的索引反转
            head.next.next = head;
            //断开原来当前梦境到下一层梦境的next的索引
            head.next = null;
            //现在原链表的最后一个节点为头节点，所以把cur返回既是反转后的链表
            return cur;
        }
    }
}
