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
    public ListNode rotateRight(ListNode head, int k) {
        
        if(head==null || head.next==null || k==0)return head;
        
        ListNode first = head;
        int len = 1;
        
        while(head.next!=null){
            head=head.next;
            len++;
        }        
        
        head.next = first;
        int cut = len-k%len;    
                
        while(cut>1){
            first = first.next;
            cut--;
        }
                
        ListNode ans = first.next;
        first.next = null;
        
        return ans;
    }
}
