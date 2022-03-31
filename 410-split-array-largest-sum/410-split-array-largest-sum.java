class Solution {
    public int splitArray(int[] nums, int m) {
        
        
        int start = largest(nums);
        int end = sum(nums);
        int ans = 0;
        
        while(start<=end){
            
         int mid = (start+end)/2;   
            
         if(isSplitCountLessThanSubarrays(nums,mid,m)){
             
             ans = mid;
             end = mid-1;
                         
         }else{
             start = mid+1; 
         } 
            
            
        }
        
        return ans;
    }

    
    public boolean isSplitCountLessThanSubarrays(int[] arr, int mid, int m){
        
        int splitCount = 1;
        int countedSubArray = 0;
        
        for(int i=0;i<arr.length;i++){
            
            countedSubArray+=arr[i];
            
            if(countedSubArray > mid){
                
                splitCount++;
                countedSubArray = arr[i];                  
            }    
        }
        
        return splitCount<=m;
    }
    

    public int sum(int[] arr){
        int sum = 0; 
 
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
  
        return sum;
    }
    
    public int largest(int[] arr)
     {
          
         int max = arr[0];
         
         for (int i = 1; i < arr.length; i++)
             if (arr[i] > max)
                 max = arr[i];
        
         return max;
     }
  
    
}
