class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        
        for(int i=0;i<spells.length;i++){
            
            int ans =  search(potions,spells[i],success);
            spells[i] = ans;
        }
        
        return spells;
    }
    
    public int search(int[] arr, int spell, long target){
        
        int start = 0, end = arr.length-1;
        int mid = 0;
        
        while(start<=end){
            
            mid = start+(end-start)/2;
            long product = (long)arr[mid]*(long)spell;

            if(product>=target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return arr.length - end -1;
    }
    
}