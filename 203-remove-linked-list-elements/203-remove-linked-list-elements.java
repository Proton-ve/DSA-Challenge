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
    public ListNode removeElements(ListNode head, int val) {
        
        ListNode dummy = head;
        
//         iterative
//         ListNode prev = null;
        
//         while(head!=null){
            
//             if(head.val==val){
//                 if(prev!=null)
//                     prev.next = head.next;
//                 else
//                     dummy = dummy.next;
                
//                 head = head.next;
//             }else{
//                 prev = head;
//                 head = head.next;
//             }
             
//         }
        
//         return dummy;
        
        if(head==null)return null;
        
        remove(head,val);
        
        return dummy.val!=val?dummy:dummy.next;
                
    }
    
    //recursive
    public void remove(ListNode head, int val){
        
        if(head==null || head.next==null)return;
        
        if(head.next.val==val){
            head.next = head.next.next;
        }else
            head = head.next;
        
        remove(head, val);
        
        return;
    }
    
    
    
}