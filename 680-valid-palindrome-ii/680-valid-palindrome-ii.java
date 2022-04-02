class Solution {
    public boolean validPalindrome(String s) {
        
        
        return palindromeChecker(s,1);
        
    }
    
    public boolean palindromeChecker(String s, int count){
        
        
        if(count<0)return false;
        
        int start = 0, end = s.length()-1;
        
        while(start<=end && count>=0){
            
            if(s.charAt(start)==s.charAt(end)){
                
                start++;
                end--;
                
            }else{
                count--;
                if(palindromeChecker(s.substring(start,end),count)) return true;
                if(palindromeChecker(s.substring(start+1,end+1),count)) return true;
                         
            }
            
            
        }
        
        if(start>end)return true;
        else return false;
        
    }
    
}