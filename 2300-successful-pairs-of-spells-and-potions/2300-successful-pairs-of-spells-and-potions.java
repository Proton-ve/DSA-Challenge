class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        
        for(int i=0;i<spells.length;i++){
            
            long key = (success%spells[i]==0)?success/spells[i]:1+success/spells[i];
            int ans =  search(potions,spells[i],key);
            spells[i] = ans;
        }
        
        return spells;
    }
    
    public int search(int[] arr, int spell, long target){
        
        int start = 0, end = arr.length-1;
        int mid = 0, ans = end+1;
        
        while(start<=end){
            
            mid = start+(end-start)/2;

            if(arr[mid]>=target){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }
        return arr.length - ans;
    }
    
}