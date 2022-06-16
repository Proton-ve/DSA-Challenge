class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length(), ans = 0;
        
        Stack<Integer> index = new Stack();
        
        index.push(-1); // -1 becoz If 1st char is ')', then we will get stack empty error without '-1' at line(21)
        
        for(int i=0; i<n; i++){
            
            char c = s.charAt(i);
            
            if(c=='('){
                index.push(i);                
            }else{
                index.pop();
                if(!index.isEmpty()){
                    ans = Math.max(i-index.peek(),ans);
                }else{
                    index.push(i);
                }
            }
        }
    
        return ans;
    }
        
}