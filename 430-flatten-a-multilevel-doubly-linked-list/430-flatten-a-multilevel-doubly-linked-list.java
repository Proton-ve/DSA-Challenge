/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        if(head==null) return head;
        
        Node temp = head, tail = head;
        Stack<Node> stack = new Stack();
        
        while(temp.next!=null || temp.child!=null){
            
            // System.out.println(temp.val);
            
            if(temp.child!=null){
                // System.out.println("child "+temp.child.val);
                if(temp.next!=null)stack.push(temp.next);
                temp.next = temp.child;
                temp.next.prev = temp;
                temp.child = null;
                
            }
                
            temp = temp.next;
             
            tail = temp;
            
        }
        
        
        if(stack.isEmpty()){
         // System.out.println("in empty stk "+head.val);
            return head;
        }
            
        while(!stack.isEmpty()){
            
            Node cont =  flatten(stack.pop());
            // System.out.println("check cont "+cont.val+"and tail is "+tail.val);
            tail.next = cont;
            cont.prev = tail;
            
            while(cont.next!=null)cont = cont.next;
            
            tail = cont;
            
        }
        
        
//         while(head.next!=null){
            
//             System.out.println("node val "+head.val);
            
//             if(head.child!=null) System.out.println("child val "+head.child.val);

//             head = head.next;
//         }
        
        
        return head;
    }
}