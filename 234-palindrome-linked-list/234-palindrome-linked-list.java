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
             
        ListNode mid = middleNode(head);
        
        ListNode sub2 = reverseList(mid);
        
        while(head!=null && sub2!=null){
            
            if(head.val!=sub2.val){
                return false;
            }
            
            head=head.next;
            sub2=sub2.next;
            
        }
        
        return true;
    }
    
    public ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null)return head;
        
        ListNode prev = null;
        ListNode second = head;
        
        while(head!=null){
            
            second = head.next!=null ? head.next : null;
            head.next = prev;
            prev = head;
            head = second;
            
            
        }
        
        return prev;
        
        
    }
    
    public ListNode middleNode(ListNode head) {
        
        ListNode fast = head, slow = head;
        
        while(fast!=null && fast.next!=null){
            
            fast = fast.next.next;       
            slow = slow.next;
        }
     
        return slow;
    }
    
}