class Solution {
    public void reverseString(char[] s) {
       
        
        reverseRecursion(s,0,s.length-1);
        
        
    }
    
    public void reverseRecursion(char[] s, int start, int end){
        
        if(start>=end){
            return;
        }
        
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        
        start = start+1;
        end = end-1;
        reverseRecursion(s,start,end);
        
        
    }
    
}