import java.util.HashMap;
import java.util.Map;

public class NetBalancePeriodCounter {
    public static long countPeriods(int[] transactions, int k) {
        Map<Long, Long> freq = new HashMap<>();
        long prefixSum = 0;
        long count = 0;

        freq.put(0L, 1L);

        for (int transaction : transactions) {
            prefixSum += transaction;

            count += freq.getOrDefault(prefixSum - k, 0L);

            freq.put(prefixSum, freq.getOrDefault(prefixSum, 0L) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] transactions1 = {3, 4, -7, 1, 3, 3, 1, -4};
        System.out.println(countPeriods(transactions1, 7));

        int[] transactions2 = {1, 2, 3};
        System.out.println(countPeriods(transactions2, 10));
    }
}