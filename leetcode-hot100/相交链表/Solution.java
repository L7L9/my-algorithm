/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB){
            return headA;
        }

        ListNode tempA = headA;
        ListNode tempB = headB;
        // 如dna那样旋转
        // 由于链表长度的不一致
        // 导致每次重新指向头节点时位置的偏差
        while(tempA != tempB){
            tempA = tempA == null?headB:tempA.next;
            tempB = tempB == null?headA:tempB.next;
        }
        // 没有相交的情况: 当偏移到一个起始点与另一个链表当前的位置时,如果此时剩下的长度一致
        // 当遍历到最后时,仍然没有相交,则同时指向null,推出循环
        return tempA;
    }
}