package poc.streams.exception;

import java.util.Arrays;
import java.util.List;

public class StreamExceptionHandling {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("1", "e", "3", "4", "5");
        strings.stream()
                .map(str -> processException(str))
                .forEach(System.out::println);
    }


    public static int processException(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException("runtime Exception");
        }
    }
}
