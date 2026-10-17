
public class PolynomialCalculator {

    static class Node {
        int coeff;
        int exp;
        Node next;

        Node(int coeff, int exp) {
            this.coeff = coeff;
            this.exp = exp;
            this.next = null;
        }
    }

    static Node addPolynomials(Node p, Node q) {
        Node dummy = new Node(0, 0);
        Node tail = dummy;

        while (p != null && q != null) {
            if (p.exp > q.exp) {
                tail.next = new Node(p.coeff, p.exp);
                p = p.next;
            } else if (q.exp > p.exp) {
                tail.next = new Node(q.coeff, q.exp);
                q = q.next;
            } else {
                int sum = p.coeff + q.coeff;

                if (sum != 0) {
                    tail.next = new Node(sum, p.exp);
                } else {
                    p = p.next;
                    q = q.next;
                    continue;
                }

                p = p.next;
                q = q.next;
            }

            tail = tail.next;
        }

        while (p != null) {
            tail.next = new Node(p.coeff, p.exp);
            tail = tail.next;
            p = p.next;
        }

        while (q != null) {
            tail.next = new Node(q.coeff, q.exp);
            tail = tail.next;
            q = q.next;
        }

        return dummy.next;
    }

    static void display(Node head) {
        if (head == null) {
            System.out.println("0");
            return;
        }

        Node temp = head;
        boolean first = true;

        while (temp != null) {
            int c = temp.coeff;
            int e = temp.exp;

            if (!first) {
                if (c > 0) {
                    System.out.print(" + ");
                } else {
                    System.out.print(" - ");
                }
            } else if (c < 0) {
                System.out.print("-");
            }

            int absCoeff = Math.abs(c);

            if (e == 0 || absCoeff != 1) {
                System.out.print(absCoeff);
            }

            if (e > 0) {
                System.out.print("x");
                if (e > 1) {
                    System.out.print("^" + e);
                }
            }

            first = false;
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Node p = new Node(5, 3);
        p.next = new Node(4, 2);
        p.next.next = new Node(2, 0);

        Node q = new Node(5, 2);
        q.next = new Node(-3, 1);
        q.next.next = new Node(1, 0);

        Node result = addPolynomials(p, q);

        System.out.print("Sum: ");
        display(result);
    }
}
