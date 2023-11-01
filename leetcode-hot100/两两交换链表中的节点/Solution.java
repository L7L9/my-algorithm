/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
     * 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // 定义一个辅助节点来将前后不同组衔接起来
        ListNode pre = new ListNode();
        pre.next = head;

        ListNode cur = head;
        ListNode after = cur.next;
        ListNode temp = pre;
        while(cur != null && after != null){
            cur.next = after.next;
            temp.next = after;
            after.next = cur;
            temp = cur;

            cur = temp.next;
            if(cur != null){
                after = cur.next;
            }
        }
        return pre.next;
    }
}