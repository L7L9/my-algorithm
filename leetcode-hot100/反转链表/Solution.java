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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode pre = null;
        ListNode last = head.next;
        ListNode temp = head;
        ListNode t;
        while(last != null){
            temp.next = pre;
            pre = temp;

            t = last.next;
            last.next = temp;
            temp = last;
            last = t;
        }

        // 题解：
        // ListNode prev = null;
        // ListNode curr = head;
        // while (curr != null) {
        //     ListNode next = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = next;
        // }
        // return prev;

        return temp;
    }
}