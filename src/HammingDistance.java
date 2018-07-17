/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
