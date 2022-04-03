class Solution {
    public void nextPermutation(int[] nums) {
        
        int n = nums.length-2, smaller = 0, i = n;
        
        for(i=n;i>=0;i--){
            
            if(nums[i]<nums[i+1]){
                
                smaller = nums[i];
                break;
            }
        }
        
        
        if(i<0){
            reverse(nums,i);
            return;
        }
        
        int j = n+1;
        
        while(j>0 && j>i && nums[j]<=nums[i]){
            j--;
        }

        
        swap(nums,i,j);
        reverse(nums,i);
        
    }
    
    
    public void swap(int[] nums, int i, int j){
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int index){
        
        int end = nums.length-1, start = index+1;
        
        while(start<end){
            
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    
}