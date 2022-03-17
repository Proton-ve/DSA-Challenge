class Solution {
    public int arrangeCoins(int n) {
     
         long count=0;
        
        for(int i=1;i<n;i++){
            count+=i;
            if(count>n) return i-1;
            if(count==n) return i;
        }
       
        return 1;
    }
}