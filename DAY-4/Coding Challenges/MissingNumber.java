import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of array (number of elements in the array)
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt(); // n elements in the array

        int[] arr = new int[n];
        System.out.println("Enter " + n + " distinct numbers from 0 to " + n + ":");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Maximum number is n, because array has n elements from 0 to n (one missing)
        int totalSum = n * (n + 1) / 2;

        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }

        int missingNumber = totalSum - arrSum;

        System.out.println("The missing number is: " + missingNumber);

        sc.close();
    }
}
