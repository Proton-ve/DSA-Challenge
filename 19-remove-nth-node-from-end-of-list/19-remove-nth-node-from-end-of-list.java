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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head.next==null)return null;
        
        ListNode fast = head, slow = head;
        int lengthOfMid = 0;
        
        while(fast!=null && fast.next!=null){
            
            lengthOfMid++;
            fast = fast.next.next;       
            slow = slow.next;
        }
     
        
        int length = fast==null? lengthOfMid*2 : (lengthOfMid*2) +1;
        
        int remain = length - lengthOfMid - n;
        
        
        ListNode prev = null;
        ListNode temp = head;
        
        if(remain>0){
            temp = slow;
        }else{
            temp = head;
            remain = lengthOfMid + remain;
        }
                
        while(remain>0){
            
                prev =  temp;
                temp = temp.next;
                remain--;
            
        }
        
        if(prev==null)return temp.next;
        
        prev.next = temp.next;
        
        
        return head;
        
    }
    
    
    
}