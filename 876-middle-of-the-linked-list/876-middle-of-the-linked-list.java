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
    public ListNode middleNode(ListNode head) {
        
        ListNode fast = head, slow = head;
        
        while(fast!=null){
            
            try{
                fast = fast.next.next;
                
            }catch(NullPointerException e){
                break;
            }
            slow = slow.next;
            
        }
     
        return slow;
    }
}