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
        Stack<Node> stack = new Stack();        // to store pointer of next nodes
        
        while(temp.next!=null || temp.child!=null){
            
            
            if(temp.child!=null){               // if node has a next and child both, then put next node in stack ...
                if(temp.next!=null)stack.push(temp.next);
                temp.next = temp.child;         // and link next to child node  
                temp.next.prev = temp;
                temp.child = null;
                
            }
                
            temp = temp.next;   // keep moving to next
            tail = temp;        // keep last node ref, as we have to joint next nodes further 
            
        }
        
        
        if(stack.isEmpty()) return head;       // if stack is null, means list is already flatten, then return 
        
            
        while(!stack.isEmpty()){        // if not already flatten, then by this step we will be having all next node pointers in stack, with latest next node on top. Now we will flatten each next node and joint with tail node
            
            Node joint =  flatten(stack.pop()); // flattening next nodes from stack
            tail.next = joint;
            joint.prev = tail;
            
            while(joint.next!=null)joint = joint.next;      // move to tail of joined next node, so that we can link it to upcoming next node in stack
            
            tail = joint;
            
        }
        
        // when stack will get empty, means we have flattened all next node and merge with final list

        return head;
    }
}