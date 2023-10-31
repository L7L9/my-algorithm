/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null){
            if(fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}