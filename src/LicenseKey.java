/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

public class LicenseKey {
    public String solution(String S, int K) {
        // write your code in Java SE 8
        StringBuilder res = new StringBuilder(S.toUpperCase().replace("-",""));
       int numberOfDash = res.length() / K -1;
        numberOfDash += (res.length()%K == 0)? 0:1;
        for (int i = 1; i <= numberOfDash; i++) {
            res.insert(S.length() - i -1 - (i * K), '-');
        }
        return res.toString();
    }
}
