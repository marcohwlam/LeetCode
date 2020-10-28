package Substring;

public class SubstringSearch {
//    public void findSubstring(String s, String t) {
//        int l = 0, r= 0;//sliding window
//        int[] map = new int[128];
//        int tracker;
//        int counter; // check whether the substring is valid
//        boolean counter_condition = true;
//        for(char c : t.toCharArray()) map[c]++; // init map
//        while(r < s.length()){
//            if(map[s.charAt(r++)]-- ? ){/*modify counter here*/}
//            while(counter_condition){
//                //logic model
//                /* update tracker here if finding minimum*/
//                //move l
//                if(map[s[l++]]++ ?){ /*modify counter here*/ }
//            }
//            /* update tracker here if finding maximum*/
//        }
//        //return
//    }

    public String minWindow(String s, String t) {
        int l = 0, r = 0;//sliding window
        int min_size = Integer.MAX_VALUE;
        int matched_counter = t.length();
        int startIndex = 0;
        // calculate the number of each character to be contained in S
        int[] dict = new int[128];
        for (char c : t.toCharArray()) dict[c]++;

        while(r < s.length()){
            //if right pointer char is in t, decrease count in dict
            if(dict[s.charAt(r++)]-- > 0) matched_counter--;
            // current window contains same number of the current character as in t
            while(matched_counter == 0){
                //update min
                if(r-l < min_size){
                    min_size = r - l;
                    startIndex = l ;
                }
                //if lost a char in t,
                if(dict[s.charAt(l++)]++ == 0) matched_counter++;
            }
        }
        return min_size == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex+min_size);
    }

    public String lengthOfLongestSubstringTwoDistinct(String s ){
        int l = 0, r = 0;//sliding window
        int max_size = Integer.MIN_VALUE;
        int distinct_counter = 0;
        int startIndex = 0;
        // calculate the number of each character to be contained in S
        int[] dict = new int[128];
        while(r < s.length()){
            //if right pointer char is in t, decrease count in dict
            if(dict[s.charAt(r++)]++ == 0) distinct_counter++;
            // current window contains same number of the current character as in t
            while(distinct_counter > 2){
                //if lost a Distinct
                if(dict[s.charAt(l++)]-- == 1) distinct_counter--;
            }
            //update max
            max_size = Math.max(max_size, r - l);
        }
        return max_size == Integer.MIN_VALUE ? "" : s.substring(startIndex, startIndex+max_size);
    }
}
