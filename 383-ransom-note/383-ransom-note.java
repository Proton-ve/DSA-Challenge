class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int n = ransomNote.length(),
            m = magazine.length(),
            uniqueChars = 0;
        
        if(m<n)return false;
        
        HashMap<Character, Integer> map = new HashMap();
        
        for(int i=0;i<n;i++){
            
            char c = ransomNote.charAt(i);
            
            map.put(c, map.getOrDefault(c,0)+1);
            
            if(map.get(c)==1)
                uniqueChars++;
            
        }
        
        for(int i=0;i<m;i++){
            
            char c = magazine.charAt(i);
            
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                
                if(map.get(c)==0)
                    uniqueChars--;
            }
            
            if(uniqueChars==0)
                return true;
            
        }
        
        return false;
    }
}