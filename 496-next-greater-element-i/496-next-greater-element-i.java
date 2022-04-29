class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] arr) {
        
        int n = arr.length-1;
     
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> nextGreaterEle = new HashMap();
        
        for(int i=n;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()<arr[i]) stack.pop();

            int ans = stack.isEmpty() ? -1:stack.peek();
            
            nextGreaterEle.put(arr[i],ans);
            
            stack.push(arr[i]);

        }
        
        for(int i=0; i<nums1.length; i++){
            
            nums1[i] = nextGreaterEle.get(nums1[i]);
            
        }
        
        return nums1;
    }
    
    
    
}