import java.util.*;

public class PhoneBook {
    private Map<Long, String> book = new HashMap<>();

    public void add(Long phone, String surname) {
        book.put(phone, surname);
    }

    public Set<Long> get(String surname) {
        Set<Long> result = new HashSet<>();
        for (Map.Entry<Long, String> pair : book.entrySet()) {
            if (surname.equalsIgnoreCase(pair.getValue())) {
                result.add(pair.getKey());
            }
        }
        return result;
    }

}
