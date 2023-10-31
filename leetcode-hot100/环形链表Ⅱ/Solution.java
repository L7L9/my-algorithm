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
     * 给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
     * 如果链表中有某个节点，可以通过连续跟踪next指针再次到达，则链表中存在环。
     * 不允许修改链表。
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        Set<ListNode> set = new HashSet();
        ListNode temp = head;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            } else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return null;
        // 题解思路: 快慢指针+数学
        // 假设头节点到环链表节点之间的个数为a,环链表的节点个数为b,即链表长度为a+b
        // 通过分析:fast节点走了2nb步,slow节点走了nb步（n指的是走了n次环链表）
        // 此时,slow再走a步,则步数为a+nb,此时,slow节点在环链表的入口

        // 根据题解思路自己写了一次
        // if(head == null || head.next == null){
        //     return null;
        // }
        //
        // ListNode slow = head;
        // ListNode fast = head;
        // while(true){
        //     if(fast == null || fast.next == null){
        //         return null;
        //     }
        //         slow = slow.next;
        //         fast = fast.next.next;
        //         if(fast == slow){
        //             break;
        //         }
        // }
        //
        // fast = head;
        // while(fast != slow){
        //     fast = fast.next;
        //     slow = slow.next;
        // }
        // return fast;
    }
}