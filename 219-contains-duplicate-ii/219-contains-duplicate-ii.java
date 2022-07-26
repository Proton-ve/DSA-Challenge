class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int n = nums.length;
        int i=0,j=0;
        HashMap<Integer, Integer> map = new HashMap();
        
        while(j<n){
            
            int ele = nums[j];
            map.put(ele,map.getOrDefault(ele,0)+1);
            
            if(map.get(ele)>1)
                return true;
            
            if(j-i == k){
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            
            j++;
        }
        
        return false;
    }
}