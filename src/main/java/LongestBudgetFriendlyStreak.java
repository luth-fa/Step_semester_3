
public class LongestBudgetFriendlyStreak {

    public static String longestStreak(int[] costs, int budget) {
        int left = 0;
        int sum = 0;
        int maxLength = 0;
        int startIndex = -1;

        for (int right = 0; right < costs.length; right++) {
            sum += costs[right];

            while (sum > budget) {
                sum -= costs[left];
                left++;
            }

            int length = right - left + 1;

            if (length > maxLength) {
                maxLength = length;
                startIndex = left;
            }
        }

        return "(" + maxLength + ", " + startIndex + ")";
    }

    public static void main(String[] args) {
        int[] costs1 = {4, 2, 1, 7, 3, 1, 2, 1, 5};
        System.out.println(longestStreak(costs1, 8));

        int[] costs2 = {9, 10};
        System.out.println(longestStreak(costs2, 8));
    }
}
