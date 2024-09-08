public class Main {
    public static void main(String[] args) {
        String[] mas = {"one", "two", "two", "three", "three", "three", "four",
                "four", "four", "four", "five", "five", "five", "five", "five"};
        System.out.println(FirstTask.findUniqueWords(mas));
        System.out.println(FirstTask.countDuplicate(mas));
        System.out.println("-------------------------------------------");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(123L, "Ivanov");
        phoneBook.add(1234L, "Petrov");
        phoneBook.add(12345L, "Sidorov");
        phoneBook.add(123456L, "Ivanov");
        phoneBook.add(1234567L, "Ivanov");
        phoneBook.add(12345678L, "Sidorov");
        System.out.println("Ivanov" + phoneBook.get("Ivanov"));
        System.out.println("Petrov" + phoneBook.get("Petrov"));
        System.out.println("Sidorov" + phoneBook.get("Sidorov"));
    }
}