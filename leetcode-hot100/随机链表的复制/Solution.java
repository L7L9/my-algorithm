/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    /**
     * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * 构造这个链表的 深拷贝。
     */
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        // 使用map保存遍历过的节点以及对应创建的节点
        Map<Node,Node> map = new HashMap<>();

        Node cur = new Node(0);
        Node node = cur;
        Node temp = head;
        while(temp != null){
            // 判断节点是否遍历过
            // 有则直接等于,否则创建并且加入到map中
            if(map.containsKey(temp)){
                Node t = map.get(temp);
                node.next = t;
                node = node.next;
            } else {
                node.next = new Node(temp.val);
                node = node.next;
                map.put(temp,node);
            }
            // 判断random中的节点是否遍历过
            // 有则直接等于,否则创建并且加入到map中
            if(temp.random != null){
                if(map.containsKey(temp.random)){
                    node.random = map.get(temp.random);
                } else {
                    Node random = new Node(temp.random.val);
                    node.random = random;
                    map.put(temp.random,random);
                }
            }
            temp = temp.next;
        }
        return cur.next;
    }
}