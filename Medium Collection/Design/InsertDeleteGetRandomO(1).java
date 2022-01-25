class RandomizedSet {
    Map<Integer, Integer> map;  // val, idx
    int[] arr;
    int idx;
    Random r;

    public RandomizedSet() {
        map = new HashMap<>();
        arr = new int[200000];
        idx = 0;
        r = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, idx);
        arr[idx++] = val;
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        int val = arr[r.nextInt(idx)];
        while(!map.containsKey(val))
            val = arr[r.nextInt(idx)];
        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
