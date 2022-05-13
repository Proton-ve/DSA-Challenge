class Solution {
    public int maxArea(int[] height) {
        
        int start = 0, end = height.length-1;
        int maxArea = Integer.MIN_VALUE;
        
        while(start<end){
            
            int minHeight = Math.min(height[start],height[end]);
            
            maxArea = Math.max(maxArea,(minHeight*(end-start)));
            
            if(height[start]<=height[end])
                start++;
            else
                end--;
            
        }
        
        return maxArea;
    }
}