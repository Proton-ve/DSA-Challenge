class Solution {
    public int lengthOfLongestSubstring(String s) {
     
        if(s.length()==0)return 0;
        
        HashMap<Character,Integer> map = new HashMap();
        int i=0,j=0,n = s.length(), ans=1;
        
        while(j<n){
            
            char c = s.charAt(j);
            
            if(!map.containsKey(c)){
                map.put(c,j);
            }else{
                if(map.get(c)<i){
                    map.put(c,j);
                }else{
                    ans = Math.max(ans,j-i);
                    i = map.get(c)+1;
                    map.put(c,j);
                }
            }
            j++;
        }
        
        return Math.max(ans,j-i);        
    }
}