class SmallestInfiniteSet {

    int i;
    PriorityQueue<Integer> q;
    HashSet<Integer> set;
    
    public SmallestInfiniteSet() {
        this.i = 1;
        this.q = new PriorityQueue();
        this.set = new HashSet();
    }
    
    public int popSmallest() {
        if(!q.isEmpty()){
            set.remove(q.peek());
            return q.poll();
        }
        return i++;
    }
    
    public void addBack(int num) {
        if(num<i && !set.contains(num)){
            q.offer(num);
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */