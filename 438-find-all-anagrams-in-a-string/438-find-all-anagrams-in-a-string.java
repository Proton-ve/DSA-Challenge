class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
     
        int n = txt.length(), k = pat.length();
        List<Integer> list = new ArrayList();
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i=0;i<k;i++){
            map.put(pat.charAt(i),map.getOrDefault(pat.charAt(i),0)+1);
        }
        
        int i=0, j=0;
        int count = map.size();
        
        while(j<n){
            
            char fast = txt.charAt(j);
            char slow = txt.charAt(i);
            
            if(map.containsKey(fast)){
                
                map.put(fast,map.get(fast)-1);
                if(map.get(fast)==0)count--;
            }
            
            if(j-i+1<k)j++;
            else{
                
                if(count==0){
                    list.add(i);
                }
                
                if(map.containsKey(slow)){
                    map.put(slow,map.get(slow)+1);
                    if(map.get(slow)==1)count++;
                }
                
                i++;j++;
            }
            
        }
     
     return list;   
        
        
        
    }
}