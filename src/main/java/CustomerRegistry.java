
import java.util.HashSet;
import java.util.Objects;

public class CustomerRegistry {

    static class Customer {
        int id;
        String name;

        Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Customer)) return false;

            Customer c = (Customer) obj;
            return id == c.id && name.equals(c.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static void main(String[] args) {
        HashSet<Customer> customers = new HashSet<>();

        System.out.println(customers.add(new Customer(1, "Asha")));
        System.out.println(customers.add(new Customer(1, "Asha")));
        System.out.println(customers.add(new Customer(2, "Ravi")));
        System.out.println("Unique count: " + customers.size());
        System.out.println("Contains Asha: "
                + customers.contains(new Customer(1, "Asha")));
    }
}
