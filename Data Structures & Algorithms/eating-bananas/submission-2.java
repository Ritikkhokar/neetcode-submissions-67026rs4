class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int l=1;
      int r = Arrays.stream(piles).max().getAsInt();
      int ans = Integer.MAX_VALUE;
      while(l<=r){
        int speed = (l+r)/2;
        int hours = calculateHours(speed, piles);
        
        if(hours<=h){
          ans = Math.min(speed, ans);
          r = speed-1;
        }else{
          l = speed+1;
        }
      }
      return ans;
    }

    public static int calculateHours(int speed, int[] piles){
        int hours = 0;
        for(int i=0;i<piles.length;i++){
            hours += piles[i]/speed + ((piles[i]%speed>0) ? 1 : 0);
        }
        return hours;
    }
}
