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
        
        ListNode leftNode = head;
        
        while(k>1){
            
            leftNode = leftNode.next;
            k--;
            
        }
        
        ListNode rightNode = head;
        ListNode temp = leftNode;
        
        while(temp.next!=null){
            temp=temp.next;
            rightNode=rightNode.next;
        }
        
        int temp2 = leftNode.val;
        leftNode.val = rightNode.val;
        rightNode.val = temp2;
        
        return head;
    }
}