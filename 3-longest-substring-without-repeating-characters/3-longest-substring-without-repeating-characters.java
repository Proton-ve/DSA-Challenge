class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> subs = new HashMap<Character,Integer>();
        
        int ans=0, n=s.length();
        
        int i=0;
        
        while(i<n){
            
            char cur = s.charAt(i);
            
            if(!subs.containsKey(cur)){
                subs.put(cur,i);
                i++;
            }else{
                int size = subs.size();
                if(size>ans)ans = size;
                int index = subs.get(cur);
                i = index + 1;
                subs.clear();
            }
            
        }
        
        return Math.max(ans,subs.size());
    }
}