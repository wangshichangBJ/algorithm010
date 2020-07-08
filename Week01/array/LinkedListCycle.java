package array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ShiChang Wang
 * @description 判断是否为循环链表
 * @date 2020/7/8
 */
public class LinkedListCycle {

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int _val){
            this.val = _val;
        }
        ListNode(int _val, ListNode _next){
            this.val = _val;
            this.next = _next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new LinkedListCycle().new Solution();
        // TO TEST
    }


    /**
     * 问题分析
     * 解题思路
     * 复杂度分析
     */
    public class Solution {
        /**
         * 使用哈希表（hashSet）来判断是否有相同的节点
         * @param head
         * @return
         */
        public boolean hasCycle1(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head)){
                    return true;
                }
                set.add(head);
                head = head.next;
            }
            return false;
        }

        /**
         * 使用双指针（快慢指针）来进行比较判断
         * 如果是环形的，快指针早晚有一天能追上慢指针。不是环形的，永远追不上
         * @param head
         * @return
         */
        public boolean hasCycle2(ListNode head) {
            if (head == null || head.next == null){
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next.next;
            while (slow != fast){
                if (fast == null || fast.next == null){
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
