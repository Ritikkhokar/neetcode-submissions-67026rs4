class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int ans = h;

        while(left<=right){
            int speed = (left+right)/2;
            int hours = checkForSuccess(piles,h,speed);
            if(hours<=h){
               ans = speed;
               right = speed-1;
            }else{
                left = speed +1;
            }
        }
        return ans;
    }

    public static int checkForSuccess(int[] piles, int h, int speed){
        int count = 0;

        for(int i=0;i<piles.length;i++){
          count += piles[i]/speed;
            if(piles[i]%speed>0){
                count++;
            }
        }
        return count;
    }
}
