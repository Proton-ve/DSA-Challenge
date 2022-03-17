class Solution {
    public int arrangeCoins(int n) {
     
        long ans = 0;
        
        long start = 0, end = n;
        
        while(start<=end){
            
            long mid = start + (end-start)/2;
            
            long k = (mid*(mid+1))/2;
            
            if(k<=n){
                ans = mid;
                start = mid+1;
            }
            
            if(k>n)end = mid-1;           
            
        }
        
        return (int)ans;
        
    }
}