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
        
        ListNode slow =  head, fast = head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode tail = fast==null? reverse(slow) : reverse(slow.next);
        if(fast!=null)slow = null;
        
        while(tail!=null && head!=null){
            if(tail.val!=head.val)return false;
            tail=tail.next;
            head=head.next;
        }
        
        return true;
    }
    
    public ListNode reverse(ListNode node){
    
        ListNode prev = null, cur = node;
        
        while(cur!=null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        return prev;        
        
    }
    
}