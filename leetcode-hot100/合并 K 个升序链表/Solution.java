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
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        int length = lists.length;
        ListNode[] nodes = new ListNode[length];

        ListNode head = new ListNode();
        ListNode temp = head;

        int index = -1;
        while(true){
            index = -1;
            for(int i = 0;i < length;i++){
                if(lists[i] != null){
                    if(index == -1){
                        index = i;
                    } else if(lists[index].val > lists[i].val){
                        index = i;
                    }
                }
            }
            // 判断是否所有链表都到尽头
            if(index == -1) break;

            temp.next = lists[index];
            lists[index] = lists[index].next;
            temp = temp.next;
        }
        return head.next;
    }
}