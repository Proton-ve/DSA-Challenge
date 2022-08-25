class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length,
            max = Integer.MIN_VALUE,
            min = Integer.MAX_VALUE;
        
        if(m*k>n)return -1;
        
        for(int i=0; i<n; i++){    
            min = Math.min(bloomDay[i],min);
            max = Math.max(bloomDay[i],max);            
        }
        
        int start = min,
            end = max,
            ans = -1;
        
        while(start<=end){
            
            // System.out.println(start+"  e is "+end);
            int mid = start + (end-start)/2;
            
            if(bouquetsMade(bloomDay, k, mid, m)){
                // System.out.println("passed "+mid);
                ans = mid;
                end = mid-1;
            }else
                start = mid+1;
            
        }
        
        return ans;
    }
    
    public boolean bouquetsMade(int[] bloomDay, int flowers, int day, int bouquets){
        
        int n = bloomDay.length,
            temp = 0;

        
        for(int i=0; i<n; i++){
            
            if(bloomDay[i]<=day)
                temp++;
            else
                temp = 0;
            
            if(temp==flowers){
                bouquets--;   
                temp = 0;
            }
            
        }
        
        return bouquets<=0;
    }
    
}