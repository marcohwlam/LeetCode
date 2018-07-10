import java.util.ArrayList;
import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
//        String outNum = "";
//        ArrayList<Character> chars_num = new ArrayList<>();
//        for (char c : num.toCharArray()) {
//            chars_num.add(c);
//        }
//        for (int i = 1; i < num.length(); i++) {
//            //remove leading 0
//            if (chars_num.get(i) == 0){
//                chars_num.remove(i);
//            }
//            //If MSB is larger than MSB - 1 remove MSB
//            if (chars_num.get(i) > chars_num.get(i + 1)) {
//                chars_num.remove(i);
//                k--;
//            }
//
//            // if MSB == MSB -1 check next different --> if MSB > next dif remove MSB
//            else if ((chars_num.get(i) == chars_num.get(i + 1)) && (i+1<num.length())) {
//                for (int j = 1; j <num.length()-i; j++) {
//                    if (chars_num.get(i + j) > chars_num.get(j + i + 1)){
//                        chars_num.remove(i);
//                        k--;
//                        break;
//                    }
//                }
//            }
//            if (k == 0) break;
//        }
//        return outNum;
        int len = num.length();
        //corner case
        if(k==len)
            return "0";

        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}
