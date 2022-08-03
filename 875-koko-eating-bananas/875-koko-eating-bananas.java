class Solution {
    public int minEatingSpeed(int[] piles, int h) {

                
        int start = 1, end = max(piles);
        
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            // System.out.println(start+" "+end+" "+mid);
            
            if(check(piles, mid, h)){
                // System.out.println(start+" pass "+end+" "+mid);
                end = mid-1;            
            }else{
                start = mid+1;                
            }
        }
    
        return start;
    }
    
    
    public boolean check(int[] arr, int mid, int h){
        
        int n = arr.length;
        
        for(int i=0; i<n; i++){
            int temp = arr[i];

            if(temp<=mid)
                h--;
            else{
                if(temp%mid==0)
                    h -= temp/mid;
                else
                    h -= (temp/mid + 1);
            }
            
        }
        
        // System.out.println("h for mid = "+mid+" is "+ h);
        
        return h>=0;
        
    }
    
    
    public int max(int[] arr){
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            if(arr[i]>max)max = arr[i];
        }
        
        return max;
    }
    
}