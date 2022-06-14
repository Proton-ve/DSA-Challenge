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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode pointer = new ListNode(0,head);
        ListNode ans = pointer;
        
        while(pointer!=null){
            
            ListNode testNode = pointer.next;
            
            for(int i=0;i<k-1 && testNode!=null;i++){
                testNode = testNode.next;                
            }
            
            if(testNode==null)break;
            
            ListNode prev = pointer, cur = pointer.next, next = null;
            
            for(int i=0;i<k;i++){
                
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            
            ListNode first = pointer.next;
            first.next = cur;
            pointer.next = prev;
            pointer = first;
            
        }
        
        return ans.next;
    }
}