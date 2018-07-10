//import java.util.Collections;
//import java.util.TreeSet;
//
//public class NextClosestTime {
//    public StringBuilder nextClosestTime(String time) {
//        time = time.replace(":", "");
//        TreeSet<Character> treeSet = new TreeSet<>(Collections.reverseOrder());
//        for (int i = 0; i < 4; i++) {
//            treeSet.add(time.charAt(i));
//        }
//        // All same digit
//        if (treeSet.size() == 1) return time;
//
//        StringBuilder resultTime = new StringBuilder();
//        resultTime.append(time);
//
//        //check if there is bigger digit in the set from the right
//        for (int i = time.length()-1; i >=0 ; --i) {
//            Character nextEle = treeSet.lower(time.charAt(i));
//            //pick the smallest num if no bigger num
//            if (nextEle == null){
//                resultTime.setCharAt(i, treeSet.last());
//                continue;
//            }
//            else if(time.charAt(i)< nextEle ){
//                resultTime.setCharAt(i, nextEle);
//            }
//        }
//        return resultTime;
//    }
//
//    private int hhmm2sec(String time) {
//        return time.charAt(0) * 360 * 10 + time.charAt(1) * 360 + time.charAt(2) * 60 + time.charAt(3);
//    }
//}
