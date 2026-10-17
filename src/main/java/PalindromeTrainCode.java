
public class PalindromeTrainCode {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        Node next;

        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }

    static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node temp = secondHalf;
        Node firstHalf = head;
        boolean result = true;

        while (temp != null) {
            if (firstHalf.data != temp.data) {
                result = false;
                break;
            }

            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        slow.next = reverse(secondHalf);

        return result;
    }

    static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println("Palindrome: " + isPalindrome(head));

        System.out.print("List after checking: ");
        display(head);
    }
}
