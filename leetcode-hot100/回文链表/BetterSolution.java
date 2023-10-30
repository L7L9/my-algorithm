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
class BetterSolution {
    private ListNode pre;

    /**
     * 题解思路:递归
     * 维护一个全局变量
     *
     */
    public boolean isPalindrome(ListNode head) {
        pre = head;
        return check(pre);
    }

    private boolean check(ListNode cur){
        if(cur != null){
            if(!check(cur.next)){
                return false;
            }
            if(pre.val != cur.val){
                return false;
            }
            pre = pre.next;
        }
        return true;
    }
}