import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        solveKnapsack();
    }

    public static void solveKnapsack() {
        int[] val = { 50, 100, 150, 200 };
        int[] wt = { 8, 16, 32, 40 };
        int W = 64;
        int n = val.length - 1;

        System.out.println(knapsack(W, n, val, wt));
    }

    public static int knapsack(int W, int n, int[] val, int[] wt) {
        if (n < 0 || W <= 0) {
            return 0;
        }

        if (wt[n] > W) {
            return knapsack(W, n - 1, val, wt);
        } else {
            return Math.max(val[n] + knapsack(W - wt[n], n - 1, val, wt), knapsack(W, n - 1, val, wt));
        }
    }
}
