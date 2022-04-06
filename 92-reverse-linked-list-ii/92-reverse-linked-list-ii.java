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
        
        if(head==null || head.next==null || left==right)return head;
        
        ListNode cur = head;
        ListNode cut1 = null;
        int count = right - left;
        int temp = left;
        
        while(cur!=null && left>1){
            
            cut1 = cur;
            cur = cur.next;
            left--;
                        
        }
  
        ListNode cut2 = cur;
        
        ListNode prev = null;
        ListNode second = null;
        
        
        while(cur!=null && count>=0){
            
            second = cur.next!=null ? cur.next : null;
            cur.next = prev;
            prev = cur;
            cur = second;
            count--;
           
        }
        
        
        if(cut1!=null)cut1.next = prev;
        else head = prev;
        
        cut2.next = cur;
                
        return head;
    }
}
