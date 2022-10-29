import java.util.Scanner;

public class SortingFashion {

    public static void sort(int arr[], int n) {
        if (arr.length == 1)
            return;
        int ans[] = new int[n];
        int min = 0, max = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1)
                ans[i] = arr[min++];
            else
                ans[i] = arr[max--];
        }
        for (int i = 0; i < n; i++)
            arr[i] = ans[i];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        sort(arr, n);
        for (int i : arr)
            System.out.print(i + " ");
        in.close();

    }

}
