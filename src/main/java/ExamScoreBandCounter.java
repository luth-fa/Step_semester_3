public class ExamScoreBandCounter {
    public static int lowerBound(int[] scores, int low) {
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < low)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static int upperBound(int[] scores, int high) {
        int left = 0, right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= high)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static int countScores(int[] scores, int low, int high) {
        return upperBound(scores, high) - lowerBound(scores, low);
    }

    public static void main(String[] args) {
        int[] scores1 = {35, 40, 45, 45, 50, 55, 60, 60, 65};
        System.out.println(countScores(scores1, 45, 60));

        int[] scores2 = {10, 20, 30, 40, 50};
        System.out.println(countScores(scores2, 25, 45));
    }
}