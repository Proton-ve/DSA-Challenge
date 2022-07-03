class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int i=0,j=0,n=nums.length;
        
        Deque<Integer> queue = new ArrayDeque();
        int[] ans = new int[n-k+1];
        
        while(j<n){
            
            while(!queue.isEmpty() && queue.getLast()<nums[j])
                queue.pollLast();
            
            queue.offer(nums[j]);
            
            if(j-i+1<k)j++;
            else{
                
                int max = queue.peek();
                ans[i] = max;
                if(nums[i]==max)queue.poll();
                i++;
                j++;
            }
            
        }
        
        return ans;
    }
}