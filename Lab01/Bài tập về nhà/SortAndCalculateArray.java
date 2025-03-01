import java.util.Arrays;
import java.util.Scanner;

public class SortAndCalculateArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);

        System.out.println("Sorted array: " + Arrays.toString(array));

        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        double average = (double) sum / size;

        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average of array elements: " + average);

        scanner.close();
    }
}
