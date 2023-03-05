import java.util.Arrays;

public class MinMax {
    public static int minmax(int[] a, int[] b) {
        // Sort arrays a and b in non-increasing order
        Arrays.sort(a);
        Arrays.sort(b);
        reverse(a);
        reverse(b);
    
        int maxA = a[0];
        int maxB = b[0];
        return maxA * maxB;
    }
    
    private static void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 6, 5, 1, 2};
        int[] b = {3, 4, 3, 2, 2, 5};
        System.out.println(minmax(a, b)); 

        int[] c = {8,7,9,6,5,6,6,5,6,4,6,7,8,5,4,3,2,1,4,5,6,7,8,7,8};
        int[] d = {2,4,5,6,7,6,7,8,9,8,7,6,7,6,5,4,3,2,3,4,5,5,5,4,5};
        System.out.println(minmax(c, d));
    }
}
