package default1;

import java.util.Arrays;

/**
 * Created by Shiyi on 9/20/2016.
 */
public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] a = {1,3,5,6,8,10};
        int[] b = {2,4,6,7,9};
        int n = a.length + b.length;
        int[] arr = new int[n];
        int i=0, j=0, k=0;
        while(i<n)
            if (j>=a.length)
                arr[i++] = b[k++];
            else if (k>=b.length)
                arr[i++] = a[j++];
            else
                arr[i++] = a[j] >= b[k] ? b[k++] : a[j++];
        System.out.println(Arrays.toString(arr));
    }
}
