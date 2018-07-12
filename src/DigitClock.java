/*
 * Created by Ho Wang Lam
 * marcohwlam@hotmail.com
 * Copyright (c) Seamless Compute 2018.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DigitClock {

    String DigitClock(String time){
        //get all digits and sort
        StringBuilder t = new StringBuilder(time.replace(":",""));
        char[] result = time.toCharArray();
        char[] digits = new char[] {result[0], result[1], result[3], result[4]};
        Arrays.sort(digits);
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i=0 ; i < 4; i++){
            indexMap.put(digits[i],i);
        }

        //For each digit right to left
        for(int i = 3; i>=0; i--){
            //if there is a bigger value
            char val = t.charAt(i);
            int index = indexMap.get(val);
            if(index < digits.length-1){
                //set to the next bigger value
                char tmp = t.charAt(i);
                t.setCharAt(i,digits[++index]);
                if(isVaildTime(t)){
                    break;
                }
                t.setCharAt(i,tmp);
            }
            //pick the smallest number
            t.setCharAt(i,result[0]);
        }
        t.insert(2, ':');
        return t.toString();
    }

    boolean isVaildTime(StringBuilder time){
        return ( (time.charAt(0)<='2' && time.charAt(1)<='4')
                || (time.charAt(0)<='1'&&time.charAt(2)<='9'&& time.charAt(3)<='5'));
    }
}
