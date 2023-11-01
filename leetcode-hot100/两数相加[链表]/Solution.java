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
     * 给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        int r = 0;
        int temp = 0;
        int a,b;
        while(l1 != null || l2 != null){
            a = l1!=null?l1.val:0;
            b = l2!=null?l2.val:0;

            temp = a + b + r;
            r = temp >= 10?1:0;
            temp %= 10;

            node.next = new ListNode(temp);
            node = node.next;

            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2 = l2.next;
            }
        }
        node.next = r==1?new ListNode(r):null;
        return head.next;
    }
}