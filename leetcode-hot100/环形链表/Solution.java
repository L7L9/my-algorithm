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
    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 如果链表中存在环，则返回 true。否则，返回 false。
     */
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