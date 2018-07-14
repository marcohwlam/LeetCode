/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

import java.util.Arrays;

public class CoinsChange {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;

        Arrays.sort(coins);
        int numberOfCoins= 0;

        //From biggest changes
        for(int i = coins.length-1; i>=0; i--){
            numberOfCoins += (amount / coins[i]);
            amount = amount%coins[i];
        }
        if (amount != 0) return -1;
        return numberOfCoins;
    }
}
