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
    public ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null)return head;
        
        //iterative
//         ListNode prev = null;
//         ListNode second = head;
        
//         while(head!=null){
            
//             second = head.next!=null ? head.next : null;
//             head.next = prev;
//             prev = head;
//             head = second;
            
            
//         }
        
//         return prev;
        
        return reverse(head, head.next, null);
        
    }
    
    //recursive
    public ListNode reverse(ListNode cur, ListNode second, ListNode prev){
        
        if(cur==null){
            return prev;
        }
        
        cur.next = prev;
        prev = cur;
        //ListNode temp = cur;
        cur = second;
        try{
            second = cur.next;
        }catch(NullPointerException e){
            second = null;
        }
               
        return reverse(cur, second, prev);
        
    }
    
}