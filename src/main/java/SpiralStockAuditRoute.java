import java.util.ArrayList;
import java.util.List;

public class SpiralStockAuditRoute {
    public static List<Integer> spiralOrder(int[][] stock) {
        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = stock.length - 1;
        int left = 0;
        int right = stock[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++)
                result.add(stock[top][i]);
            top++;

            for (int i = top; i <= bottom; i++)
                result.add(stock[i][right]);
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--)
                    result.add(stock[bottom][i]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    result.add(stock[i][left]);
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] stock = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        System.out.println(spiralOrder(stock));
    }
}
