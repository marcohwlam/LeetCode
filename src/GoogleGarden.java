/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

public class GoogleGarden {
    // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
    public int solution(int[] A, int K, int M) {
        // write your code in Java SE 8
        // Max sliding window
        // Create the array for position
        //postion[i] = x ; i is flower position, x is day of opening
        //eg ([1, 2, 7, 6, 4, 3, 5], 2, 2)
        // pos = [1 2 6 5 7 4 3]

        // day 1 [1 0 0 0 0 0 0]
        // day 2 [1 1 0 0 0 0 0]
        // day 3 [1 1 0 0 0 0 1]
        // day 4 [1 1 0 0 0 1 1]
        // day 5 [1 1 0 1 0 1 1] <--found [0 1] [5 6]

        int[] postion = new int[A.length];
        int longGroupCount = 0;
        for (int i = 0; i < A.length; i++) {
            postion[A[i] - 1] = i + 1;
        }
        int l = 0, r = K - 1, res = -1;
        for (int i = 0; r < postion.length - 1; i++) {
            //slide the window if empty
            if (postion[i] < postion[l] && postion[i] < postion[r])
                continue;
            //We found the window that all flower bloom in between left and right
            if (i == r) {
                res = Math.max(res, Math.max(postion[r], postion[l]));
                longGroupCount++;
            }

            if (longGroupCount == M)
                return res;
            // move window to next
            r = i + K - 1;
            l = i;
        }
        return -1;
    }

}
