class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length(), ans = 0;
        
        Stack<Character> para = new Stack();
        Stack<Integer> index = new Stack();
        
        index.push(-1);
        
        for(int i=0; i<n; i++){
            
            char c = s.charAt(i);
            
            if(c=='('){
                
                index.push(i);
                para.push('(');
                
            }else{
                
                if(!para.isEmpty()){
                    
                    para.pop();
                    index.pop();
                    ans = Math.max(i-index.peek(),ans);
                    
                    
                }else{
                    
                    index.push(i);
                    
                }
                
            }
            
        }
    
        return ans;
    }
        
}