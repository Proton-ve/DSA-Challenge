class Solution {
    public int maxOperations(int[] nums, int k) {
        
        int count = 0, n = nums.length;
        
        Map<Integer,Integer> map = new HashMap(n);
                
        for(int i=0; i<n; i++){
            
            int remain = k - nums[i];
            
            if(map.getOrDefault(remain,-1)>0){
                
                count++;
                map.put(remain,map.get(remain)-1);
                
                
            }else{
                
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                
                
            }
            
        }
        
        return count;
    }
}



 
    
    /*
    
    
    ***********O(NlogN)****************
    
    public int maxOperations(int[] nums, int k) {
        
        Arrays.sort(nums);
        int count=0;
        int start = 0, end = nums.length-1;
        
        while(start<end){
                        
            int sum = nums[start]+nums[end];
            
            if(sum==k){
                start++;
                end--;
                count++;
            }else
                if(sum<k)
                    start++;
                else 
                    end--;
            
            
        }
        
       return count; 
    }
    
    
    
    **************O(n^2)*************
    
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
    
    
    
    */ 
    