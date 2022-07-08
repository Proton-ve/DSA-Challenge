class Solution {
    public int totalFruit(int[] fruits) {
        
        Map<Integer,Integer> map = new HashMap();
        
        int i=0,j=0,n=fruits.length,count=0,ans=1;
        
        while(j<n){
            
            int end = fruits[j];
            map.put(end,map.getOrDefault(end,0)+1);
            
            if(map.get(end)==1)count++;
            if(count<=2)ans = Math.max(ans,j-i+1);
            
            if(count>2){
                while(count>2){
                    int start = fruits[i];
                    map.put(start,map.get(start)-1);
                    if(map.get(start)==0)count--;
                    i++;
                }
            }
            j++;
        }
        
        // System.out.println(map);
        
     return ans;   
    }
}