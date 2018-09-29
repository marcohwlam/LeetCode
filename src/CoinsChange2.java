import java.util.Arrays;

public class CoinsChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || amount ==0) return 1;
        int[] dp = new  int[amount + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j = 1; j <dp.length; j++){
                if( j - coins[i] >= 0){
                    dp[j] += dp[j-coins[i]];
                }
            }
        }
        return  dp[amount];
    }
}
