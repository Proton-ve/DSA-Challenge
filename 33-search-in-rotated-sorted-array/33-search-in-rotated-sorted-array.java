class Solution {
    public int search(int[] nums, int t) {
        
        int s=0,e = nums.length-1;
        
        while(s<=e){
            
            int m = s + (e-s)/2;
            
            int midE = nums[m];
            
            if(midE==t)return m;
            
            if(midE<nums[s]){
                if(t>midE && t<=nums[e])
                    s=m+1;
                else
                    e=m-1;
            }else{
                if(t<midE && t>=nums[s])
                    e=m-1;
                else
                    s=m+1;
            }
            
            
        }
        
        return -1;
    }
}