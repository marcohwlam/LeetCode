/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

public class KEmptySlots {
    public int kEmptySlots(int[] flowers, int k) {
        //Max sliding window
        //day[i] = x ; i is flower position, x is day of opening
        int[] postion = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++){
            postion[flowers[i] - 1] = i + 1;
        }
        int l = 0, r = k + 1, res = Integer.MAX_VALUE;
        for (int i = 0; r < postion.length; i++) {
            if(postion[i] > postion[l] && postion[i] > postion[r])
                continue;
            //We found the window that no flower bloom in between left and right
            if (i == r)
                res = Math.min(res, Math.max(postion[r], postion[l]));
            // move window to next
            r = i + k + 1;
            l = i;
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

//    public int solution(int[] A, int K, int M) {
//        // write your code in Java SE 8
//        // Max sliding window
//        // Create the array for position
//        //postion[i] = x ; i is flower position, x is day of opening
//        if(K == 1) return M;
//        int[] postion = new int[A.length];
//        int longGroupCount = 0;
//        for (int i = 0; i < A.length; i++){
//            postion[A[i] - 1] = i + 1;
//        }
//        int l = 0, r = K - 1, res = -1;
//        for (int i = 0; r < postion.length-1; i++) {
//            //slide the window if empty
//            if(postion[i] < postion[l] && postion[i] < postion[r])
//                continue;
//            //We found the window that all flower bloom in between left and right
//            if (i == r){
//                res = Math.max(res, Math.max(postion[r], postion[l]));
//                longGroupCount++;
//            }
//
//            if(longGroupCount == M)
//                return res;
//            // move window to next
//            r = i + K - 1;
//            l = i;
//        }
//        return -1;
//    }
}
