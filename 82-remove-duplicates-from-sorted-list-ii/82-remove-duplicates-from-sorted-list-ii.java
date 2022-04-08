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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null || head.next==null) return head;
        
        ListNode temp = head;
        ListNode prev = null;
        
        while(temp!=null && temp.next!=null){
            
            if(temp.val==temp.next.val){
                
                while(temp.next!=null && temp.val==temp.next.val){
                    temp.next = temp.next.next!=null?temp.next.next:null;
                }
                
                if(prev==null){
                    
                    ListNode store = temp.next;
                    temp.next = null;
                    temp = store;
                    head = temp;

                    
                }else{                
                prev.next = temp.next!=null?temp.next:null;
                temp = prev.next;
                }
            }
            else{
                prev = temp;
                temp = temp.next;
            }
                        
        }
        
        return head;
        
        
      }
}