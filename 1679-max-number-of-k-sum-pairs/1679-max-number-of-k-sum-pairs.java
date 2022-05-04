class Solution {
    public int maxOperations(int[] nums, int k) {
        
        int count = 0, n  = nums.length;
        
        for(int i=0; i<n; i++){
            
            int num = nums[i];
            
            if(num>0 && num<k){
                
                int target = k - num;
                int search = search(nums, i+1, target);
                
                if(search>0){
                    
                    nums[i] = -1;
                    nums[search] = -1;
                    count++;
                }              
            }
            
            
        }
        
        return count;
    }
    
    
    
    public int search(int[] arr, int start, int key){
        
        for(int i=start;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    } 
    
    
}