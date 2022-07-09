class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character,Integer> map = new HashMap();
        int i=0, j=0, n=s.length();
        boolean flag = false;
        
        for(int p=0;p<t.length();p++)
            map.put(t.charAt(p),map.getOrDefault(t.charAt(p),0)+1);
        
        int count = map.size(), minWindow = Integer.MAX_VALUE, windowEnd = 0, windowStart = 0;
        
        while(j<n){
            
            char end = s.charAt(j);
            
            if(map.containsKey(end)){
                map.put(end,map.get(end)-1);
                if(map.get(end)==0)
                    count--;
            }

                while(count==0){
                    flag = true;
                    if(j-i+1<minWindow){
                        windowEnd = j;
                        windowStart = i;
                        minWindow = j-i+1;
                    }
                    
                    char start = s.charAt(i);
                    
                    if(map.containsKey(start)){
                        // if(map.get(start)<0){
                            map.put(start,map.get(start)+1);
                            if(map.get(start)>0)count++; // I got stuck here
                        // }
                    }
                    i++;
                }
            
            j++;
        }
            
        // System.out.println(lastInd);
        return flag? s.substring(windowStart,windowEnd+1):"";
    }
    
}