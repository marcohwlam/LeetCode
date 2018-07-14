/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DigitClock {

    String DigitClock(String time){
        //get all digits and sort
        StringBuilder t = new StringBuilder(time.replace(":",""));
        // Get unique digits
        Set<Character> set = new HashSet<>();
        for(int i=0; i<4; i++) {
            set.add(t.charAt(i));
        }
        // Sort them
        List<Character> digits = new ArrayList<>(set);
        Collections.sort(digits);
        // Create digit to index map for O(1) lookup
        Map<Character,Integer> indexMap = new HashMap<>();
        for(int i=0; i<digits.size(); i++) {
            indexMap.put(digits.get(i),i);
        }
        // For each digit, right to left
        for(int digit=3; digit>=0; digit--) {
            char val = t.charAt(digit);
            int index = indexMap.get(val);
            // If there is a larger value available, try it
            if(index < digits.size()-1) {
                char tmp = t.charAt(digit);
                t.setCharAt(digit,digits.get(++index));
                if(isValidTime(t))
                    break;
                t.setCharAt(digit,tmp);
            }
            // Otherwise, replace with smallest value and move to next digit
            t.setCharAt(digit,digits.get(0));
        }
        t.insert(2,':');
        return t.toString();
    }

    boolean isValidTime(StringBuilder time){
        return ( (time.charAt(0)<='2' && time.charAt(1)<='4')
                || (time.charAt(0)<='1'&&time.charAt(2)<='9'&& time.charAt(3)<='5'));
    }
}
