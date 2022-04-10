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
    
    
    public boolean check(ListNode head, int k){
        
        while(head!=null && k>0){
            
            head = head.next;
            k--;
            
        }
        
        return k==0;
        
    }
    
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(k==1) return head;
        //k = k-1;
        int t = k-1;
        ListNode temp = head;
        ListNode dummy = head;
        
        while(t>0){
            
            temp = temp.next;
            t--;
        }
        
        int left = 1, right = k;
        ListNode temp2 = head;
        
        while(check(temp2,k)){
            // System.out.print("temp2 is ");
            // display(temp2);
           // if(check(temp2,k)){
                
                temp2 = reverseBetween(dummy,left,right, k);
                dummy = temp;
               //  System.out.print("op is ");
               // display(temp);
          //  }else{
            //     System.out.print("dsq");
            //     break;
            // }
        
        
            
            left = left+k;
            right = right+k;
            
        }
                
        
        
           
        return temp;
        
    }
    
    
    
    public ListNode reverseBetween(ListNode head, int left, int right, int k) {
        
        System.out.println("left is "+left +"right is "+right);
        
      //  display(head);
        
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
                
        return cut2.next;
    }
    
    
    public void display(ListNode head){
        
        while(head!=null){
            System.out.print(head.val+"->");
            head = head.next;
        }
        
        System.out.println();
        
    } 
    
    
}