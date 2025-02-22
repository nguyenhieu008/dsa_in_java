import back_tracking.BackTracking;

public class Main {
    public static void main(String[] args) {
        int[][] c = new int[][]{{0, 3, 2, 1},
                                {3, 0, 1, 2},
                                {2, 1, 0, 4},
                                {1, 2, 4, 0},};
        BackTracking.salesmen(4, c);
    }
}
