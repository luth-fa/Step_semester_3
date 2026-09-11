package string;

public class FoodOrder {

    private String studentName;
    private String dishName;
    private boolean delivered;

    public FoodOrder(String studentName, String dishName) {

        if (studentName == null || studentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be blank.");
        }

        if (dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Dish name cannot be blank.");
        }

        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
        this.delivered = false;
    }

    void markDelivered() {

        if (!delivered) {
            delivered = true;
            System.out.println("Order delivered successfully.");
        } else {
            System.out.println("Warning: Order was already delivered.");
        }
    }

    static void processBatch(String[][] rawOrders) {

        int valid = 0;
        int rejected = 0;

        for (int i = 0; i < rawOrders.length; i++) {

            try {

                String studentName = rawOrders[i][0];
                String dishName = rawOrders[i][1];

                FoodOrder order =
                        new FoodOrder(studentName, dishName);

                valid++;

            } catch (Exception e) {

                rejected++;
            }
        }

        System.out.println("Valid: " + valid
                + " | Rejected: " + rejected);
    }

    public static void main(String[] args) {

        String[][] rawOrders = {
                {"Ravi", "Paneer Butter Masala"},
                {"", "Chole Bhature"},
                {"Meera", " "},
                {"Divya", "Veg Biryani"}
        };

        processBatch(rawOrders);

        System.out.println();

        FoodOrder order =
                new FoodOrder("Ravi", "Paneer Butter Masala");

        order.markDelivered();
        order.markDelivered();
    }
}