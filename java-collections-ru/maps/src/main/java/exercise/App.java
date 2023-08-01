lspackage exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        // Создаем новый словарь для хранения слов и их количества
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Разбиваем предложение на слова, используя пробел в качестве разделителя
        String[] words = sentence.split("\\s+");

        // Обрабатываем каждое слово
        for (String word : words) {
            // Если слово уже есть в словаре, увеличиваем его количество на 1
            if (wordCountMap.containsKey(word)) {
                int count = wordCountMap.get(word);
                wordCountMap.put(word, count + 1);
            } else {
                // Если слова нет в словаре, добавляем его со значением 1
                wordCountMap.put(word, 1);
            }
        }

        return wordCountMap;
    }

    public static String toString(Map<String, Integer> wordCountMap) {
        StringBuilder sb = new StringBuilder();

        sb.append("{\n");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        sb.append("}");

        return sb.toString();
    }

    public static void main(String[] args) {
        String sentence = "Lorem ipsum dolor sit amet consectetur adipiscing elit";
        Map<String, Integer> wordCountMap = getWordCount(sentence);
        String result = toString(wordCountMap);
        System.out.println(result);
    }
}
//END
