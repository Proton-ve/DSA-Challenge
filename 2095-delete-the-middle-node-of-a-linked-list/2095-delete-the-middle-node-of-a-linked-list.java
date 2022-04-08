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
    public ListNode deleteMiddle(ListNode head) {
        
        if(head.next==null)return null;
        
        ListNode temp = middleNode(head);
        temp.next = temp.next.next;
        
        return head;
    }
    
    public ListNode middleNode(ListNode head) {
        
        ListNode fast = head, slow = head, prev = head;
        
        while(fast!=null && fast.next!=null){
            
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
     
        return prev;
    }
    
}