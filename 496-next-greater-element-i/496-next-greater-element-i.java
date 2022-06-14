class Solution {
    
    public int[] nextGreaterElement(int[] nums1, int[] arr) {
        
        int n = arr.length-1;
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> nextGreaterEle = new HashMap();
        
        for(int i=n;i>=0;i--){

            while(!stack.isEmpty() && stack.peek()<arr[i])
                stack.pop();
            
            nextGreaterEle.put(arr[i],(stack.isEmpty() ? -1:stack.peek()));
            stack.push(arr[i]);
        }
        
        int n1 = nums1.length;
        
        for(int i=0; i<n1; i++)
            nums1[i] = nextGreaterEle.get(nums1[i]);
        
        return nums1;
    }
    
    
    // brute force
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
//         int len1 = nums1.length;
//         int len2 = nums2.length;
        
//         Map<Integer,Integer> nextGreaterEle = new HashMap();
        
//         for(int i=0; i<len2;i++){
            
//             nextGreaterEle.put(nums2[i],-1);
                        
//             for(int j=i+1; j<len2; j++){
                                
//                 if(nums2[j]>nums2[i]){
                    
//                     nextGreaterEle.put(nums2[i],nums2[j]);
//                     break;
//                 }
//             }
//         }
                
//         for(int i=0; i<len1; i++) nums1[i] = nextGreaterEle.get(nums1[i]);
     
//      return nums1;  
//     }
    
    
    
}