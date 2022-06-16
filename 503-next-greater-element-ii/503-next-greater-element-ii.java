class Solution {
    public int[] nextGreaterElements(int[] nums) {
     
        int n = nums.length;
        int[] nums2 = new int[n];
        Stack<Integer> stack = new Stack();
        
        for(int i=2*n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[i%n]>=stack.peek())
                stack.pop();
            nums2[i%n] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%n]);
        }
        
        return nums2;
    }
}