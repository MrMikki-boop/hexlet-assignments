package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {

    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\n"))
                .filter(line -> line.contains("environment"))
                .flatMap(line -> {
                    String variables = line.replaceAll(".*=\"(.*)\"", "$1");
                    return Arrays.stream(variables.split(","))
                            .map(variable -> variable.split("="))
                            .filter(pair -> pair[0].startsWith("X_FORWARDED_"))
                            .map(pair -> pair[0].replace("X_FORWARDED_", "") + "=" + pair[1]);
                })
                .collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        // Пример использования метода
        String content = "[program:prepare]\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'\n" +
                "autorestart=false\n" +
                "environment=\"X_FORWARDED_MAIL=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en\"\n" +
                "[program:http_server]\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make environment'\n" +
                "environment=\"key5=value5,X_FORWARDED_var3=value,key6=value6\"";

        String result = App.getForwardedVariables(content);
        System.out.println(result); // => "MAIL=tirion@google.com,HOME=/home/tirion,var3=value"
    }
}
//END
