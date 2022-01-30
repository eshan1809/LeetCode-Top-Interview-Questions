class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char ch : tasks)
            arr[ch - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr)
            if(i > 0)
                pq.add(i);
        Queue<Pair> q = new ArrayDeque<>();
        int time = 0;
        while(!(pq.isEmpty() && q.isEmpty())){
            time++;
            if(!q.isEmpty() && q.peek().time + n < time)
                pq.add(q.remove().freq);
            if(!pq.isEmpty()){
                int rem = pq.remove();
                if(rem > 1)
                    q.add(new Pair(rem - 1, time));
            }
        }
        return time;
    }
    
    class Pair{
        int freq, time;
        Pair(int freq, int time){
            this.freq = freq;
            this.time = time;
        }
    }
}
