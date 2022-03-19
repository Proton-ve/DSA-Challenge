class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> subs = new HashMap<Character,Integer>();
        
        int ans=0, i=0, n=s.length();
                
        while(i<n){
            
            char cur = s.charAt(i);
            
            if(!subs.containsKey(cur)){
                subs.put(cur,i);
                i++;
            }else{
                ans = Math.max(ans,subs.size());
                i = subs.get(cur) + 1;
                subs.clear();
            }
            
        }
        
        return Math.max(ans,subs.size());
    }
}