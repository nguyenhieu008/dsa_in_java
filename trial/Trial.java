package trial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trial {

    private static final Map<String, Integer> lowNumbers = new HashMap<>(Map.ofEntries(
            Map.entry("zero", 0),
            Map.entry("one", 1),
            Map.entry("two", 2),
            Map.entry("three", 3),
            Map.entry("four", 4),
            Map.entry("five", 5),
            Map.entry("six", 6),
            Map.entry("seven", 7),
            Map.entry("eight", 8),
            Map.entry("nine", 9)
    ));

    private static final Map<String, Integer> midNumbers = new HashMap<>(Map.ofEntries(
            Map.entry("ten", 10),
            Map.entry("eleven", 11),
            Map.entry("twelve", 12),
            Map.entry("thirteen", 13),
            Map.entry("fourteen", 14),
            Map.entry("fifteen", 15),
            Map.entry("sixteen", 16),
            Map.entry("seventeen", 17),
            Map.entry("eighteen", 18),
            Map.entry("nineteen", 19)
    ));

    private static final Map<String, Integer> highNumbers = new HashMap<>(Map.ofEntries(
            Map.entry("twenty", 20),
            Map.entry("thirty", 30),
            Map.entry("forty", 40),
            Map.entry("fifty", 50),
            Map.entry("sixty", 60),
            Map.entry("seventy", 70),
            Map.entry("eighty", 80),
            Map.entry("ninety", 90)
    ));

    private static final Map<String, Long> multipliers = Map.of(
            "hundred", 100L,
            "thousand", 1000L,
            "million", 1000000L,
            "billion", 1000000000L,
            "trillion", 1000000000000L
    );

    private static int getRank(String unit) {
        switch (unit) {
            case "hundred":
                return 1;
            case "thousand":
                return 2;
            case "million":
                return 3;
            case "billion":
                return 4;
        }
        return 0;
    }

    private static long getTokenValue(String token) {
        String[] words = token.split(" ");
        if (words.length == 2) {
            int first = highNumbers.get(words[0]);
            int second = lowNumbers.get(words[1]);
            return (long) first + second;
        } else {
            if (lowNumbers.containsKey(token)) return lowNumbers.get(token);
            if (midNumbers.containsKey(token)) return midNumbers.get(token);
            if (highNumbers.containsKey(token)) return highNumbers.get(token);
        }
        return -1;
    }

    public static long convertToNumber(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }

        text = text.toLowerCase().replace("-", " ").replace(" and ", " ");
        String[] words = text.trim().split("\\s+");

        int n = words.length;
        ArrayList<String> tokens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (highNumbers.containsKey(words[i]) && i + 1 < n && lowNumbers.containsKey(words[i + 1])) {
                tokens.add(words[i] + " " + words[i + 1]);
                i++;
            } else {
                tokens.add(words[i]);
            }
        }

        System.out.println("tokens = " + tokens);


        boolean isDigitOnly = true;
        for (String word : words) {
            if (multipliers.containsKey(word)) {
                isDigitOnly = false;
                break;
            }
        }

        if (isDigitOnly) {
            String result = "";
            for (String token : tokens) {
                result += getTokenValue(token);
            }
            return Long.valueOf(result);
        }

        Stack<String> s = new Stack<>();

        int m = tokens.size();
        for (int i = 0; i < m; i++) {
            String t = tokens.get(i);
            if (!multipliers.containsKey(t)) {
                s.push(String.valueOf(getTokenValue(t)));
            } else {
                long v = Long.valueOf(s.pop());

                long temp = 0;

                while (!s.isEmpty() && getRank(s.peek()) < getRank(t)) {
                    long nextU = multipliers.get(s.pop());
                    long nextV = Long.valueOf(s.pop());

                    temp += nextU * nextV;
                }

                s.push(Long.toString(temp));
                s.push(t);
            }
        }

        long result = 0;
        if (s.size() % 2 == 1) {
            result = Long.valueOf(s.pop());
        }

        while (!s.isEmpty()) {
            long u = multipliers.get(s.pop());
            long v = Long.valueOf(s.pop());

            result += u * v;
        }

        return result;
    }
    public static void main(String[] args) {
        // Test cases
        String[] tests = {
//                "two zero one",            // 201
//                "twenty thirteen",         // 2013
//                "forty two",              // 42
//                "one hundred twenty three", // 123
//                "two zero zero three",    // 2003
//                "nineteen ninety nine",
//                "forty two twenty one",
//                "one hundred twenty three",
                "one thousand three hundred forty five",
//                "one million two hundred thirty four thousand five hundred sixty seven",
                "Fifty One hudred thousand Billion Six Hundred and Seventy Five Million Eight Hundred and One Thousand Two Hundred and Thirty Five"
        };

        for (String test : tests) {
            System.out.printf("%s = %d   %n", test, convertToNumber(test));
        }
    }
}
