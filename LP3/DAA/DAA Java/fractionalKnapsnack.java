import java.util.Arrays;
import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        fractionalKnapsack();
    }

    public static void fractionalKnapsack() {
        int[] weights = { 10, 20, 30 };
        int[] values = { 60, 100, 120 };
        int capacity = 50;
        double res = 0; // Use double for the result

        Integer[] indices = new Integer[weights.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        // Sort the items by their value-to-weight ratio in descending order
        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                double ratio1 = (double) values[i1] / weights[i1];
                double ratio2 = (double) values[i2] / weights[i2];
                return Double.compare(ratio2, ratio1); // Reverse order
            }
        });

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (capacity <= 0) {
                break;
            }
            if (weights[index] > capacity) {
                // Add a fraction of the item to the knapsack
                res += capacity * ((double) values[index] / weights[index]);
                capacity = 0;
            } else if (weights[index] <= capacity) {
                // Add the whole item to the knapsack
                res += values[index];
                capacity -= weights[index];
            }
        }

        System.out.println(res);
    }
}
