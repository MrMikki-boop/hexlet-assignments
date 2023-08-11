package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        List<String> freeDomains = Arrays.asList("gmail.com", "yandex.ru", "hotmail.com");

        long count = emails.stream()
                .map(email -> email.substring(email.lastIndexOf('@') + 1))
                .filter(domain -> freeDomains.contains(domain))
                .count();

        return count;
    }
}
// END
