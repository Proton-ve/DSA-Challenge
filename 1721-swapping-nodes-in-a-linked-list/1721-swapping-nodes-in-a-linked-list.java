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
    public ListNode swapNodes(ListNode head, int k) {
     
        if(head==null || head.next==null)return head;
        
        int length = 0;
        ListNode temp = head;
        
        
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        
        ListNode dummy = head;
        ListNode leftNode = head, rightNode = head;
        
        int left = k, right = length-k+1;
        int lvalue=0, rvalue=0;
        
        while(dummy!=null){
            
            left--;
            right--;
            
            
            
            if(left<=0){
                
                lvalue = leftNode.val;
            }else{
                leftNode = leftNode.next;
            }
            
            if(right<=0){
                
                rvalue = rightNode.val;
            }else{
                rightNode = rightNode.next;
            }
            
            dummy = dummy.next;
            
        }
        
        // System.out.println(rvalue+" "+lvalue);
        
        leftNode.val = rvalue;
        rightNode.val = lvalue;
        
        return head;
    }
}