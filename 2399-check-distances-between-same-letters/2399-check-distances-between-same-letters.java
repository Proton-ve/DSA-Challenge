class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap();
        
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,i-map.get(c)-1);
            }else{
                map.put(c,i);
            }
        }
        
        for(Map.Entry<Character,Integer> itr : map.entrySet()){
            
            char c = itr.getKey();
            
            if(distance[c-'a'+0]!=itr.getValue())
                return false;
        }
        
        return true;
        
    }
}