import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("1st method");
        printThreeWords();
        System.out.println("2nd method");
        checkSumSign();
        System.out.println("3rd method");
        printColor();
        System.out.println("4th method");
        compareNumbers();
        System.out.println("5th method");
        System.out.println(checkSum(2, 5));
        System.out.println("6th method");
        printPositivity(-8);
        System.out.println("7th method");
        System.out.println(isNegative(-3));
        System.out.println("8th method");
        printFewTimes("java", 5);
        System.out.println("9th method");
        System.out.println(isLeap(2020));
        System.out.println("10th method");
        System.out.println(Arrays.toString(inverseArray(
                new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0})));
        System.out.println("11th method");
        System.out.println(Arrays.toString(getFilledArray()));
        System.out.println("12th method");
        System.out.println(Arrays.toString(multiplySomeElementsInArray()));
        System.out.println("13th method");
        System.out.println(Arrays.deepToString(fillMatrix()));
        System.out.println("14th method");
        System.out.println(Arrays.toString(generateArray(13, 7)));
    }

    /**
     * 1
     */
    private static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    /**
     * 2
     */
    private static void checkSumSign() {
        int a = 1999999999, b = 1999999999;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Суммма отрицательная");
        }
    }

    /**
     * 3
     */
    private static void printColor() {
        int value = 100;
        if (value > 100) {
            System.out.println("Зеленый");
        } else if (value > 0) {
            System.out.println("Желтый");
        } else {
            System.out.println("Красный");
        }
    }

    /**
     * 4
     */
    private static void compareNumbers() {
        int a = 1000, b = 0;
        if (a >= b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

    /**
     * 5
     */
    private static boolean checkSum(int a, int b) {
        if ((a + b) <= 20 && (a + b) >= 10) return true;
        else return false;
    }

    /**
     * 6
     */
    private static void printPositivity(long checkValue) {
        if (checkValue < 0) System.out.println("Отрицательное");
        else System.out.println("Положительное");
    }

    /**
     * 7
     */
    private static boolean isNegative(long checkValue) {
        if (checkValue < 0) return true;
        else return false;
    }

    /**
     * 8
     */
    private static void printFewTimes(String str, long times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    /**
     * 9
     */
    private static boolean isLeap(int checkValue) {
        if (checkValue % 400 == 0) return true;
        if (checkValue % 100 == 0) return false;
        if (checkValue % 4 == 0) return true;
        return false;
    }

    /**
     * 10
     */
    private static int[] inverseArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) array[i] = 1;
            else array[i] = 0;
        }
        return array;
    }

    /**
     * 11
     */
    private static int[] getFilledArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    /**
     * 12
     */
    private static int[] multiplySomeElementsInArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) array[i] *= 2;
        }
        return array;
    }

    /**
     * 13
     */
    private static int[][] fillMatrix() {
        int[][] array = new int[25][25];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][array.length - i - 1] = 1;
        }
        return array;
    }

    /**
     * 14
     */
    private static int[] generateArray(int length, int initialValue) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}