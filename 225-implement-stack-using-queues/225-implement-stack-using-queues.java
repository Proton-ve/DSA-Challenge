class MyStack {
    
    Queue<Integer> q1 = new ArrayDeque();

    public MyStack() {
        
    }
    
    public void push(int x) {
        
        q1.offer(x);
        
    }
    
    public int pop() {
        
        int n = q1.size();
        
        for(int i=0;i<n-1;i++){
            
            q1.offer(q1.poll());
            
        }
    
        int ans = q1.poll();
        
        return ans;
        
    }
    
    
    public int top() {
        
        int n = q1.size();
        
        for(int i=0;i<n-1;i++){
            
            q1.offer(q1.poll());
            
        }
    
        int ans = q1.peek();
        q1.offer(q1.poll());
        
        return ans;
        
    }
    
    public boolean empty() {
     
        if(q1.isEmpty())return true;
        else return false;
        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */