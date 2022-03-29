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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     
        // Make a new result ListNode on which we will make changes
        ListNode temp = new ListNode();
        
        // Take reference to head node of result list 
        ListNode ans = temp;
        
        while(list1!=null && list2!=null){
            
            // choose smaller element from both list and insert into result list
            if(list1.val<list2.val){
                temp.next = new ListNode(list1.val);
                list1 = list1.next!=null ? list1.next:null;
                temp = temp.next;
            }else{
                temp.next = new ListNode(list2.val);
                list2  = list2.next!=null ? list2.next:null;
                temp = temp.next;
            }
            
        }
        
        // Check if any list is left to merge
        if(list1!=null){
            
            while(list1!=null){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
                temp = temp.next;
            }
        }
        
        if(list2!=null){
            
            while(list2!=null){
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
                temp = temp.next;
            }
        }
     
        // return reference node we made earlier
        return ans.next;
    }
}