
import java.util.HashMap;

public class LibraryPlatform {
    public static void main(String[] args) {
        HashMap<Integer, String> books = new HashMap<>();

        books.put(101, "Java Programming");
        books.put(102, "Data Structures");
        books.put(103, "Artificial Intelligence");

        int searchId = 102;

        if (books.containsKey(searchId)) {
            System.out.println("Book found: " + books.get(searchId));
        } else {
            System.out.println("Book not found");
        }

        books.remove(101);

        System.out.println("Total books: " + books.size());
        System.out.println("All books:");

        for (Integer id : books.keySet()) {
            System.out.println(id + " - " + books.get(id));
        }
    }
}
