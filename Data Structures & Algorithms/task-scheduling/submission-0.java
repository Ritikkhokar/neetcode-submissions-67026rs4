public class Pair{
    int num;
    int toi;

    Pair(int num, int toi){
        this.num = num;
        this.toi = toi;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int[] frequency = new int[26];
        for(int i=0;i<tasks.length;i++){
            frequency[tasks[i]-'A']++;
        }
      
      for(int i=0;i<frequency.length;i++){
        if(frequency[i]>0){
            maxHeap.offer(frequency[i]);
        }
      }
      Queue<Pair> q = new LinkedList<>();
      int time = 0;
      while(maxHeap.size()>0 || q.size()>0){
        time++;
        if(q.size()>0){
            if(q.peek().toi == time){
                maxHeap.offer(q.remove().num);
            }
        }
        if(maxHeap.size()>0){
          int ele = maxHeap.poll();
           ele--;
           if(ele>0){
             q.add(new Pair(ele,time+n+1));
           }
        }
        
      }
      return time;

    }
}
