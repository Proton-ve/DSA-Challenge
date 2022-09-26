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
    public ListNode mergeKLists(ListNode[] lists) {
     
        PriorityQueue<ListNode> nodes = new PriorityQueue(new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        
        int n = lists.length;
        
        for(int i=0;i<n;i++){
            
            ListNode e = lists[i];
                        
            while(e!=null){
                ListNode temp = e.next;
                e.next = null;
                nodes.offer(e);
                e = temp;
            }
        }
        
        ListNode head = nodes.poll();
        ListNode ans = head;
        
        while(!nodes.isEmpty()){
            ListNode cur = nodes.poll();
            head.next = cur;
            head = head.next;
        }
       
        return ans;
    }
}