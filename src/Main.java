public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов Иван Иванович", "Директор",
                "CEO@company.com", 375_172_000_000L, 780000d, 27);
        employees[1] = new Employee("Петров Петр Петрович", "Технический " +
                "директор", "CTO@company.com", 375_17_200_00_01L, 780000d, 25);
        employees[2] = new Employee("Сидоров Сидор Сидорович", "Директор по " +
                "маркетингу", "CMO@company.com", 375_17_200_00_02L, 780000d, 25);
        employees[3] = new Employee("Кузнецов Кузьма Кузьмич", "Финансовый " +
                "директор", "CFO@company.com", 375_17_200_00_03L, 780000d, 24);
        employees[4] = new Employee("Энтони Дэниелс", "Начальник протокольного" +
                " отдела", "C3PO@company.com", 375_17_200_00_04L, 780000d, 78);

    }
}