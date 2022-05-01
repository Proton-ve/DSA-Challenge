class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        int n1 = s.length();
        int i=0;
        
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();
        
        while(i<n1){
            
            char c = s.charAt(i++);
            
            if(c!='#')s1.push(c);
            else{
                if(!s1.isEmpty())s1.pop();
            } 
            
        }
        
        n1 = t.length();
        i=0;
        
        while(i<n1){
            
            char c = t.charAt(i++);
            
            if(c!='#')s2.push(c);
            else{
                if(!s2.isEmpty())s2.pop();
            } 
            
        }
        
        while(!s1.isEmpty() && !s2.isEmpty() && s1.peek()==s2.peek()){
            
            s1.pop();
            s2.pop();
            
        }
        
        return s1.isEmpty() && s2.isEmpty();
       
    }
}