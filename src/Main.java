import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        KEmptySlots M = new KEmptySlots();
//        int[] inoput= {1, 2, 7, 6, 4, 3, 5};
//        System.out.println(M.kEmptySlots(inoput, 1));
        HammingDistance M = new HammingDistance();
//        System.out.println(M.solution(inoput, 2, 2));
        int[] inoput= {1, 2, 7, 6, 4, 3, 5};
//        System.out.println(M.solution(inoput, 1, 3));
//        DigitClock N = new DigitClock();
////        int[] inoput= {6, 5, 8, 9, 7, 1,10, 2, 3, 4};
        System.out.println(M.hammingDistance(3,1));

    }
}
