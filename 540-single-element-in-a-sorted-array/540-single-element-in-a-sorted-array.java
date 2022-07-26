class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int n=nums.length-1;
        int s=0, e=n;
        
        while(s<=e){
            
            int m = s+(e-s)/2;            
            
            if(m%2==0){
                if(m<n && nums[m]==nums[m+1])
                    s = m+1;
                else if(m>0 && nums[m]==nums[m-1])
                    e = m-1;
                else 
                    return nums[m];
            }else{
                if(m<n && nums[m]==nums[m+1])
                    e = m-1;
                else if(m>0 && nums[m]==nums[m-1])
                    s = m+1;
                else 
                    return nums[m];
                
            }
            
        }
        
        return -1;
    }
}