class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int start = 0, end = arr.length-1;
        
        int mid = 0, ans = 0, peek = 0;
        
        while(start<=end){
            
            mid = start + (end-start)/2;
            
            if(arr[mid]<arr[mid+1]){
                
                start = mid+1;
                
            }else{
                
                if(arr[mid]>peek){
                    ans = mid;
                    peek = arr[mid];
                }
                
                end = mid-1;
                
            }
                        
        }
        
        return ans;
    }
}
