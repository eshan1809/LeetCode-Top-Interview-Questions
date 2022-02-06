class LRUCache {
    
    Map<Integer, Node> cache;
    Node head, tail;
    int capacity, size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        Node ret = cache.get(key);
        removeNode(ret);
        addNode(ret);
        return ret.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            removeNode(cache.get(key));
            cache.get(key).val = value;
            addNode(cache.get(key));
        } else{
            Node add = new Node(key, value);
            cache.put(key, add);
            addNode(add);
            size++;
            if(size > capacity){
                size--;
                Node rem = tail.prev;
                cache.remove(rem.key);
                removeNode(rem);
            }
        }
    }
    
    private void removeNode(Node rem){
        rem.prev.next = rem.next;
        rem.next.prev = rem.prev;
    }
    
    private void addNode(Node add){
        add.next = head.next;
        head.next.prev = add;
        add.prev = head;
        head.next = add;
    }
    
    class Node{
        Node next, prev;
        int key, val;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        } 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
