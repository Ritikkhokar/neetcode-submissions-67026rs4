class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        int hours = h;
        int resSpeed = 0;
        while(left<=right){
            int speed = (left + right)/2;
            hours = checkForSucess(piles, speed);
            if(hours<=h){
              resSpeed = speed;
              right = speed-1;
            }else{
              left = speed+1;
            }
        }
        return resSpeed;
    }

    public static int checkForSucess(int[] piles, int k){
        int count = 0;
         for(int i=0;i<piles.length;i++){
            if(k>piles[i]){
              count++;
            }else{
             count += piles[i]/k;
             if(piles[i]%k>0){
                count++;
             }
            }
         }
         return count;
    }
}
