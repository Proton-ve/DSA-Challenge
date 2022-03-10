problem link - https://leetcode.com/problems/add-two-numbers/



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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        
        ListNode sumNode = new ListNode(0);
        ListNode head = sumNode;
    
        int sum=0;
        int rem=0;
        
        while(l1!=null || l2!=null){
        
            sum+=rem;
            
            if(l1!=null){

                sum+=l1.val;
                l1=l1.next;

            }

            if(l2!=null){

                sum+=l2.val;
                l2=l2.next;

            }
            
            sumNode.next = new ListNode(sum%10);
            sumNode=sumNode.next;
            
            if(sum/10 ==1)rem=1;
            else rem=0;
            
            sum=0;
        }
        
        if(rem==1)sumNode.next = new ListNode(1);
        
    return head.next;
        
        
    }
}