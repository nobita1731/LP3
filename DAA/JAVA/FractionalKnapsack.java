import java.util.Arrays;
import java.util.Comparator;

class Item {
    public int profit;
    public int weight;

    public Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class FractionalKnapsack {
    public static double fractionalKnapsack(int W, Item[] items) {
        // Arrays.sort(items, Comparator.comparingDouble(item -> item.profit * 1.0 / item.weight).reversed());
        Arrays.sort(items, Comparator.comparingDouble(item -> -((double) item.profit / item.weight)));

        double totalValue = 0.0;

        for (Item item : items) {
            if (W >= item.weight) {
                // Take the whole item
                W -= item.weight;
                totalValue += item.profit;
            } else {
                // Take a fraction of the item
                totalValue += (item.profit * 1.0 / item.weight) * W;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        int maxWeight = 50;
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        double maxValue = fractionalKnapsack(maxWeight, items);
        System.out.println("Maximum value obtained is: " + maxValue);
    }
}
