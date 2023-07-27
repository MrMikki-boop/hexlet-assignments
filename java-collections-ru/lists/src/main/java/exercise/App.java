package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static void main(String[] args) {
        // Пример использования метода scrabble()
        String availableChars = "abcdefg";
        String wordToCheck = "face";
        System.out.println(scrabble(availableChars, wordToCheck)); // Выведет true
    }

    public static boolean scrabble(String availableChars, String word) {
        // Преобразовать оба входных аргумента в нижний регистр
        availableChars = availableChars.toLowerCase();
        word = word.toLowerCase();

        // Преобразовать набор символов в список для удобства манипуляций
        List<Character> charsList = new ArrayList<>();
        for (char c : availableChars.toCharArray()) {
            charsList.add(c);
        }

        // Проверить наличие каждого символа из слова в списке символов
        for (char c : word.toCharArray()) {
            if (!charsList.contains(c)) {
                return false;
            }
            // Если символ найден, удалить его из списка, чтобы избежать повторного использования
            charsList.remove(Character.valueOf(c));
        }

        return true;
    }
}
//END
