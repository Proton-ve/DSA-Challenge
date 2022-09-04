class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length,
            i=0,
            j=0,
            robots=0;
        
        long totalCost = 0, sumCost=0;
        
        Deque<Integer> deque = new ArrayDeque();
        
        while(j<n){
            
            sumCost += runningCosts[j];
            
            while(!deque.isEmpty() && chargeTimes[deque.getLast()]<chargeTimes[j])
                deque.pollLast();
            
            deque.offer(j);
             totalCost = chargeTimes[deque.peek()] + (j-i+1)*sumCost;
            
            if(totalCost > budget){
                if(deque.peek()<=i)
                    deque.pollFirst();
                
                sumCost -= runningCosts[i++];
            }
            
//             while(i<j && totalCost>budget){
                
//                 // System.out.println("dqpk "+deque.peek()+" i="+i);
                
//                 if(deque.peek()<=i)
//                     deque.pollFirst();
                
//                 sumCost -= runningCosts[i++];
//                 totalCost = chargeTimes[deque.peek()] + (j-i+1)*sumCost;
//             }
            
            if(totalCost<=budget)
                robots = Math.max(robots,j-i+1);
            
            j++;            

        }
            
        return robots;
    }
    
}