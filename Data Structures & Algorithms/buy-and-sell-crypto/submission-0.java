class Solution {
    public int maxProfit(int[] prices) {
        int[] rightMaxArr = new int[prices.length];
        rightMaxArr[prices.length-1] = prices[prices.length-1];
        for(int i = prices.length-2; i>=0; i--){
           if(prices[i]>rightMaxArr[i+1]){
            rightMaxArr[i] = prices[i];
           }else{
            rightMaxArr[i] = rightMaxArr[i+1];
           }
        }

        int totalProfit = 0;

        for(int i=0;i<prices.length;i++){
        totalProfit = Math.max(totalProfit, rightMaxArr[i]-prices[i]);
    }
    return totalProfit;
    }
}
