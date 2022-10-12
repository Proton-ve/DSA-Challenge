class Solution {
    public List<List<String>> partition(String s) {
     
        return solve(s, 0, new ArrayList());
    }
    
    public List<List<String>> solve(String s, int strt, List<String> out){
        
        List<List<String>> list = new ArrayList();
        
        if(strt>=s.length()){
            list.add(new ArrayList(out));
            return list;
        }
        
        for(int i=strt+1;i<=s.length();i++){
            
            String sub = s.substring(strt,i);
            
            if(isPalindrome(sub)){
                out.add(sub);
                list.addAll(solve(s, i, out));
                out.remove(out.size()-1);
            }
        }
        
        return list;
    }
    
    public boolean isPalindrome(String str){
        
        int n = str.length();
        int s=0, e = n-1;
        
        while(s<=e){
            
            if(str.charAt(s)!=str.charAt(e))
                return false;
            
            s++;
            e--;
        }
        
        return s>e;
    }
    
}