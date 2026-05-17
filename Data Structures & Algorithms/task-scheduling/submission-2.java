class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char ch : tasks){
            count[ch - 'A']++;
        }
        Arrays.sort(count);

        int totalIdle = (count[25]-1)*n;
        for(int i=24;i>=0 && count[i]>0; i--){
            totalIdle -= Math.min(count[i], count[25]-1);
        }
        if(totalIdle>0){
            return tasks.length + totalIdle;
        }else{
            return tasks.length;
        }
    }
}
