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
        
        if(k==1)return head;
        
        ListNode dum = head, ans = null;
        int ind = --k;
        int itr = 1;
        
        ListNode prev = new ListNode(-1,dum);
        
        while(dum!=null && dum.next!=null){
            
            dum = dum.next;
            ind--;
            
            
            if(ind==0){
                
                if(itr==1){
                    ans = dum;
                    itr++;
                }
                // System.out.println(dum.val);
                
                ListNode temp = dum.next!=null?dum.next:null;
                ListNode start = prev.next;
                ListNode point = reverseBtwnTwoNodes(start,dum);
                
                prev.next = point;
                start.next = temp;
                dum = temp;
                prev = start;
                ind = k;
                
            }
            
        }
        
        
        return ans;
    }
    
    public ListNode reverseBtwnTwoNodes(ListNode start, ListNode end){
        
        ListNode first = start;
        ListNode cur = start.next;
        
        while(start!=end){
            
            ListNode curNext = cur.next;
            cur.next = start;
            start = cur;
            cur = curNext;
        }
        
        first.next = start.next;
        
        return start;
    }
    
}