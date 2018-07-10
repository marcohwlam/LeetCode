import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        MaximizeDistanceToClosestPerson M = new MaximizeDistanceToClosestPerson();
        int[] inoput= {1,0,0,0};
        int ret= M.maxDistToClosest(inoput);
        System.out.println(ret);
    }

}
