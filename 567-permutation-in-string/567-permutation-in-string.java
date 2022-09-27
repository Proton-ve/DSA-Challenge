class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length()>s2.length())
            return false;
        
        int i=0, j=0, n1=s1.length(), n2=s2.length();
        
        HashMap<Character,Integer> map = new HashMap();
        
        for(int p=0;p<n1;p++){
            char c = s1.charAt(p);
            map.put(c,map.getOrDefault(c,0)+1);
        }
             
        while(j<n2-n1+1){
            if(map.containsKey(s2.charAt(j))){
                if(check(map,s2,j,j+n1-1))
                    return true;
            }
            i++;
            j++;
        }
        
        return false;
    }
               
    public boolean check(HashMap<Character,Integer> s1map, String str, int l, int r){
        
        HashMap<Character,Integer> map  = new HashMap(s1map);
        int count = map.size();
        
        for(int i=l;i<=r;i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }
            map.put(c,map.get(c)-1);
            if(map.get(c)==0)count--;
        }
        
        return count==0;
    }
               
}