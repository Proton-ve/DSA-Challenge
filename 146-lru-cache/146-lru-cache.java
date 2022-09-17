class LRUCache {
    
    class Node{
        Node prev, next;
        int key, val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer, Node> map;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.capacity = capacity;
        this.map = new HashMap();
        
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key))
            return -1;
        
        Node curNode = this.map.get(key);
        remove(curNode);
        insert(curNode);
        return curNode.val;
    }
    
    public void put(int key, int value) {
        
        Node newNode = new Node(key, value);
        
        if(this.map.containsKey(key)){
            remove(this.map.get(key));
        }else
            if(map.size()==capacity){
                int temp = this.tail.prev.key;
                remove(this.tail.prev);
                this.map.remove(temp);
            }
        
        insert(newNode);
        this.map.put(key,newNode);
    }
    
    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void insert(Node node){
                
        Node temp = this.head.next;
        
        this.head.next = node;
        node.prev = this.head;
        node.next = temp;
        temp.prev = node;
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */