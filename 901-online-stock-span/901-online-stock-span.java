class StockSpanner {
    
    Stack<int[]> span = new Stack();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
        
        int curSpan = 1;
        
        while(!span.isEmpty() && span.peek()[0]<=price){
            curSpan+=span.pop()[1];
        }
        
        span.push(new int[]{price,curSpan});
        
        return curSpan;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */