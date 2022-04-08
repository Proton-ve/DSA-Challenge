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
    public void reorderList(ListNode head) {
        
        if(head.next==null || head.next.next==null)return;
        
        ListNode mid = middleNode(head);
        ListNode sub = reverseList(mid);

        
        ListNode temp1 = head;
        ListNode temp2 = head;
            
        while(head!=null){
            
            if(head.next==null){
                head.next = sub;
                break;
            }
            
            temp1 = head.next;
            head.next = sub;
            temp2 = sub.next;
            sub.next = temp1;
            sub = temp2;
            head = temp1;
                        
        }
        
        
    }
    
     public ListNode middleNode(ListNode head) {
        
        ListNode fast = head, slow = head;
        ListNode prev = head;
        
        while(fast!=null && fast.next!=null){
            
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
     
         prev.next = null;
        return slow;
    }



public ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null)return head;
        
        //iterative
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


}