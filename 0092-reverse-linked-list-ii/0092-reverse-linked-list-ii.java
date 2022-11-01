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
    public ListNode reverseBetween(ListNode head, int left, int right) {
     
        ListNode join = new ListNode(-501,head);
        
        int totalRev = right - left;
        
        int l = left;
        
        while(l-->1){
            join = join.next;
        }
        
        ListNode end = join.next;
        ListNode cur = end.next;
        ListNode prev = end;
        ListNode next = null;
        
        while(totalRev-->0){
            
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            
        }
        
        end.next = cur;
        join.next = prev;
        
        return left>1?head:join.next;
    }
}