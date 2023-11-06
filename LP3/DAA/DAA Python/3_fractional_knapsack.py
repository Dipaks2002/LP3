def fractional_knapsack():
    weights=[10,20,30]
    values=[60,100,120]
    capacity=50
    res=0
    # Pair : [Weight,value]
    for pair in sorted(zip(weights,values), key= lambda x: x[1]/x[0], reverse=True):
        if capacity<=0: # Capacity completed - Bag fully filled 
            break 
        if pair[0]>capacity: # Current's weight with highest value/weight ratio Available Capacity
            res+=int(capacity * (pair[1]/pair[0]))  # Completely fill the bag.
            capacity=0
        elif pair[0]<=capacity: # Take the whole object
            res+=pair[1]
            capacity-=pair[0]
    print(res)        

if __name__=="__main__":
    fractional_knapsack()


"""import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        fractionalKnapsack();
    }

    public static void fractionalKnapsack() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;
        int res = 0;

        Integer[] indices = new Integer[weights.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingDouble(i -> (double) values[i] / weights[i]).reversed());

        for (int i = 0; i < indices.length; i++) {
            int index = indices[i];
            if (capacity <= 0) {
                break;
            }
            if (weights[index] > capacity) {
                res += (int) (capacity * ((double) values[index] / weights[index]));
                capacity = 0;
            } else if (weights[index] <= capacity) {
                res += values[index];
                capacity -= weights[index];
            }
        }

        System.out.println(res);
    }
}"""