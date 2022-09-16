class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int maxArea=0, n=heights.length;
        Stack<Integer> stack = new Stack();
        
        for(int i=0;i<=n;i++){
            
            int cur = i<n?heights[i]:0;
            
            if(!stack.isEmpty() && heights[stack.peek()]<=cur){
                stack.push(i);
            }else{
                
                while(!stack.isEmpty() && heights[stack.peek()]>cur){
                    
                    int curHeight = stack.pop();
                    int curArea = stack.isEmpty()?heights[curHeight]*(i-0)
                                                 :heights[curHeight]*(i-stack.peek()-1);
                    maxArea = Math.max(curArea,maxArea);
                }
                stack.push(i);
            }
        }
        return maxArea;
    }
}