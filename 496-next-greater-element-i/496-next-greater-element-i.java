class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] arr) {
        
        int n = arr.length-1;
     
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> nextGreaterEle = new HashMap();
        
        for(int i=n;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()<arr[i]) stack.pop();
            
            nextGreaterEle.put(arr[i],(stack.isEmpty() ? -1:stack.peek()));
            
            stack.push(arr[i]);

        }
        
        int n1 = nums1.length;
        
        for(int i=0; i<n1; i++){
            
            nums1[i] = nextGreaterEle.get(nums1[i]);
            
        }
        
        return nums1;
    }
    
    
    
}