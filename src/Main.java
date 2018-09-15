import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        KEmptySlots M = new KEmptySlots();
//        int[] inoput= {1, 2, 7, 6, 4, 3, 5};
//        System.out.println(M.kEmptySlots(inoput, 1));
        ChampagneTower C = new ChampagneTower();
//        System.out.println(M.solution(inoput, 2, 2));
        int[] inoput= {1, 2, 7, 6, 4, 3, 5};
//        TreeNode node = new TreeNode(3);
//        node.left = new TreeNode(9);
//        node.right = new TreeNode(20);
//        node.right.left = new TreeNode(15);
//        node.right.right = new TreeNode(7);
////        System.out.println(M.solution(inoput, 1, 3));
//        DigitClock N = new DigitClock();
////        int[] inoput= {6, 5, 8, 9, 7, 1,10, 2, 3, 4};
        double a = C.champagneTower(1,0,0);
        System.out.println(a);

//         a = C.champagneTower(0,1,0);
//        System.out.println(a);
//            a = C.champagneTower(2,1,1);
//        System.out.println(a);


    }
}
