
package string;

import java.util.Scanner;

public class Palindrome {

    static boolean iterativePalindrome(String text) {
        int i = 0;
        int j = text.length() - 1;

        while (i < j) {
            if (text.charAt(i) != text.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    static boolean recursivePalindrome(String text, int i, int j) {
        if (i >= j) {
            return true;
        }

        if (text.charAt(i) != text.charAt(j)) {
            return false;
        }

        return recursivePalindrome(text, i + 1, j - 1);
    }

    static boolean arrayPalindrome(String text) {
        char[] original = text.toCharArray();
        char[] reverse = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reverse[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " + iterativePalindrome(text));
        System.out.println("Recursive: " + recursivePalindrome(text, 0, text.length() - 1));
        System.out.println("Array Reversal: " + arrayPalindrome(text));

        sc.close();
    }
}