class Solution {
    public int removeDuplicates(int[] nums) {
        
        int index = 1, j = 0;
        
        for(int i=0; i<nums.length; i++){
            
            
            while(j<nums.length && nums[i]==nums[j]){
                j++;
            }
            
            if(j==nums.length)break;
            
            nums[index] = nums[j];
            index++;
            i=j-1;
            j++;
            
        }
        
        
     return index;   
    }
}