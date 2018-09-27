import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        GameOfLife G = new GameOfLife();
        int[][] in = new int[][] {
                {0,1,0},
                {0,1,0},
                {1,1,1},
                {0,0,0}
        };
        G.gameOfLife(in);
    }
}
