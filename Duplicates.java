public class Duplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 4, 4, 6, 7, 9, 9};
        int[] result = new int[arr.length];
        result[0] = arr[0];
        int j = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result[j] = arr[i];
                j++;
            }
        }
        System.out.print(" Number after removing duplicates: ");
        for (int i = 0; i < j; i++) {
            System.out.print(result[i] + " ");
        }
    }
}