class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] - b[0]);
        int n = people.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = -1;
            arr[i][1] = -1;
        }
        for(int i = 0; i < n; i++){
            int count = -1;
            for(int j = 0; j < n; j++){
                if(arr[j][0] == -1 || arr[j][0] >= people[i][0])
                    count++;
                if(count == people[i][1]){
                    arr[j][0] = people[i][0];
                    arr[j][1] = people[i][1];
                    break;
                }
            }
        }
        return arr;
    }
}
