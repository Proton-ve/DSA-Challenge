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
    public ListNode partition(ListNode head, int x) {
        
        ListNode cut1 = new ListNode(-101,head);
        ListNode ans = cut1.next;
        // ListNode cut2 = new ListNode(-101,head);
        ListNode dummy = head;
        
        // if(dummy.val<x){
        //     cut1 = dummy;
        //     cut2 = dummy.next;
        // }
        
        ListNode cur = dummy, prev = cut1;
        
        while(cur!=null){
            
            if(cur.val<x){
                
                if(prev!=cut1){
                    
                    ListNode temp = cur.next;
                    ListNode joint1 = cut1.next;
                    cut1.next = cur;
                    cur.next = joint1;
                    prev.next = temp;
                    if(cut1.val==-101)ans = cut1.next;
                    cut1 = cur;
                    cur = temp;
                }else{
                    cut1 = cur;
                    prev = cur;
                    cur = cur.next;
                }
                
            }else{
                prev = cur;
                cur = cur.next;
            }
            
            
        }
        
        return ans;
    }
}