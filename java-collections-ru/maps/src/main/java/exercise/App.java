package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        if (sentence == null || sentence.trim().isEmpty()) {
            return wordCountMap;
        }

        String[] words = sentence.split(" ");
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    public static String toString(Map<String, Integer> wordCountMap) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (!wordCountMap.isEmpty()) {
            sb.append("\n");
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                String word = entry.getKey();
                int count = entry.getValue();
                sb.append("  ").append(word).append(": ").append(count).append("\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
//END
