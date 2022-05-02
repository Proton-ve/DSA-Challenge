class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int s = 0, e = nums.length-1;
        int n = e+1;
        
        while(s<e){
        
            while(s<e && nums[s]%2==0) s++;

            while(s<e && nums[e]%2!=0) e--;
            
            if(s<e){
                
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                
                s++; 
                e--;
                
            }else break;
            
            
        }
        
         return nums;
        
    }
}