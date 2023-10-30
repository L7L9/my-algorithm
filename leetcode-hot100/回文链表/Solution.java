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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();
        // 使用快慢指针
        // 将链表前半段加入到栈中
        while(fast != null){
            stack.push(slow.val);
            if(fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            } else {
                break;
            }
        }
        // 将前半段和后半段进行判断
        while(!stack.empty()){
            int num = stack.pop();
            if(slow.val != num){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }
}