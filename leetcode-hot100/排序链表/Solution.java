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
     * 给你链表的头结点head，请将其按升序排列并返回排序后的链表
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     */
    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        // 将链表转换为列表
        for(ListNode cur = head;cur != null;cur = cur.next){
            list.add(cur);
        }
        // 排序
        list.sort((node1,node2)->{return node1.val - node2.val;});
        // 将排序后的节点串起来
        ListNode result = new ListNode();
        ListNode temp = result;
        for(int i = 0;i < list.size();i++){
            temp.next = list.get(i);
            temp = temp.next;
        }
        if(temp != null){
            temp.next = null;
        }
        return result.next;
    }
}