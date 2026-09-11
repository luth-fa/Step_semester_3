package string;

import java.util.HashMap;
import java.util.Scanner;

public class StopWordFrequencyReport {

    static void generateReport(String paragraph) {

        String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replace(".", "");
        paragraph = paragraph.replace(",", "");

        String[] words = paragraph.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            boolean isStopWord = false;

            for (int j = 0; j < stopWords.length; j++) {

                if (words[i].equals(stopWords[j])) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord) {
                frequency.put(words[i], frequency.getOrDefault(words[i], 0) + 1);
            }
        }

        frequency.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .forEach(entry ->
                        System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter paragraph: ");
        String paragraph = sc.nextLine();

        generateReport(paragraph);

        sc.close();
    }
}