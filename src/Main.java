
public class Main {
    public static void main(String[] args) {
        String[][] array1 = new String[4][5];
        String[][] array2 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "not a number", "4"}};
        String[][] array3 = {{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}};

        try {
            int result = workWithArray(array1);
            System.out.println("result=" + result);
        } catch (MyArrayDataException | MyArraySizeException e) {
            e.printStackTrace();
        }
    }


    public static int workWithArray(String[][] arr)
            throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4 || arr[0].length != 4 || arr[1].length != 4
                || arr[2].length != 4 || arr[3].length != 4)
            throw new MyArraySizeException("Array size not 4*4");
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(String.format(
                            "can't cast \"%s\" to Integer in row %d, column %d"
                            , arr[i][j], i, j));
                }
            }
        }
        return result;
    }
}