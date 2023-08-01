lspackage exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Разделяем предложение на слова по пробелам
        String[] words = sentence.split("\\s+");

        // Подсчитываем количество каждого слова
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        return wordCountMap;
    }

    public static String toString(Map<String, Integer> wordCountMap) {
        StringBuilder sb = new StringBuilder("{\n");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            sb.append("  ").append(entry.getKey()).append("=").append(entry.getValue()).append(",\n");
        }
        // Удаляем запятую после последней пары ключ-значение
        if (!wordCountMap.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("\n}");

        return sb.toString();
    }

    public static void main(String[] args) {
        String sentence = "java is the best programming language java";
        Map<String, Integer> wordsCount = App.getWordCount(sentence);
        System.out.println(App.toString(wordsCount));
    }
}
//END
