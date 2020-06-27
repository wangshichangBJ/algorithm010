package queue;

/**
 * 合并两个有序链表
 */
public class mergeTwoLists {

    public class ListNode {
          int val;
          ListNode next;
          public ListNode() {}
          public ListNode(int val) {
              this.val = val;
          }
          public ListNode(int val, ListNode next) {
              this.val = val;
              this.next = next;
          }
    }

    /**
     * 使用递归方法合并两个有序链表
     * @param l1 链表1
     * @param l2 链表2
     * @return 新链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val > l2.val){
            //若l1的值大于l2的值，返回l2的值，并设置l2.next为l1与l2.next比较后的min值
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        if (l1.val < l2.val){
            //若l1的值小于l2的值，返回l1的值，并设置l1.next为l1.next与l2比较后的min值
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        return null;
    }
}
