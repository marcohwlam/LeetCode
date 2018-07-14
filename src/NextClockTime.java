/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NextClockTime {

    private Set<String> permutationSet = new HashSet<>();

    private void permute(String time, int l, int r) {
        if (l == r && isValidTime(time)) permutationSet.add(time);
        for (int i = l; i <= r; i++) {
            time = swap(time, l, i);
            permute(time, l + 1, r);
            time = swap(time, l, i);
        }
    }

    public Set<String> getPermutation() {
        return permutationSet;
    }

    private String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public String nextClockTime(String time) {
        //remove ":"
        time = time.replace(":", "");
        //Create Set of permutation in permutationSet
        permute(time, 0, time.length() - 1);
        List<String> permutation = new ArrayList<>(permutationSet);
        Collections.sort(permutation);
        //set index to current time
        int index = permutation.indexOf(time);
        //return the first permutation of the next day if there is not bigger permutation in today
        if (index == permutation.size() - 1) {
            return permutation.get(0);
        }
        //move index to the next larger valid permutation
        return new StringBuilder(permutation.get(index + 1)).insert(2, ":").toString();
    }

    private boolean isValidTime(String time) {
        return ((time.charAt(0) <= '2' && time.charAt(1) <= '3')
                || (time.charAt(0) <= '1' && time.charAt(2) <= '9' && time.charAt(3) <= '5'));
    }
}
