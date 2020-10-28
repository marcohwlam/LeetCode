package Sorting;

public class SortByPattern {
    public String sortByPattern(String str, String patten){
        StringBuilder sortedStr = new StringBuilder();
        int[] map = new int[128];
        for(char c : str.toCharArray()){ map[c]++;}
        //count occurence of each char in str

        //foreach char in patten look up the occ map and put them in the sortedStr
        for (char c: str.toCharArray()){
            while (map[c] >0){
                sortedStr.append(c);
                map[c]--;
            }
        }
        return sortedStr.toString();
    }
}
