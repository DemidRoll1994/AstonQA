import java.util.*;

public class FirstTask {

    public static Map<String, Integer> countDuplicate(String[] mas) {
        Map<String, Integer> counter = new HashMap<>();
        for (String i : mas) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
        return counter;
    }

    public static Set<String> findUniqueWords(String[] mas) {
        return new HashSet<>(Arrays.asList(mas));
    }
}
