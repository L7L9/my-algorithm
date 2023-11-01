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
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        // 快慢指针
        ListNode node = head;
        ListNode fast = head;
        // 快指针先走n步或者走到尽头
        while(n >= 0 && fast != null){
            fast = fast.next;
            n--;
        }
        // 若走完n步刚好在尽头，则说明是去掉第一个节点
        if(fast == null && n == 0){
            return head.next;
        }
        while(fast != null){
            node = node.next;
            fast = fast.next;
        }
        if(node.next != null){
            node.next = node.next.next;
        }
        return head;
    }
}