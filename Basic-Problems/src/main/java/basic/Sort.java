package basic;


import java.lang.String;import java.lang.System; /**
 * Created by jai on 8/18/15.
 */
public class Sort {
    //Lets write quicksort..
    int [] a = new int[20];


    private static void quicksort(int[] a, int lower, int upper) {
        if (upper < lower || upper == lower) {
            return;
        }
        int pivot = a[upper];
        int j = upper - 1;
        int i = lower;
        while (i <= j) {
            if (a[i] >= pivot) {
                //swap
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                j--;
            } else {
                i++;
            }
        }
        a[upper] = a[i];
        a[i] = pivot;
        quicksort(a, lower, i - 1);
        quicksort(a, i+1, upper);
    }

    static void print(int[] a) {
        for (int i= 0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k=0;
        while(i < a.length && j < b.length) {
            if(a[i] == b[j]) {
                c[k++] = a[i++];
                c[k++] = b[j++];
            } else if(a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        if(i < a.length) {
            while(i < a.length) {
                c[k++] = a[i++];
            }
        } else {
            while(j < b.length) {
                c[k++] = b[j++];
            }
        }
        return c;
    }

    static int[] createhalfarray(int[] a, int lower, int upper) {
        int [] x = new int[upper-lower +1];
        for(int i = 0; i < x.length; i++) {
            x[i] = a[lower++];
        }
        return x;
    }
    static int[] mergesort(int []a) {
        if(a.length <= 1) {
            return a;
        }
        int half = a.length / 2;
        int[] x = createhalfarray(a, 0, half - 1);
        int[] y = createhalfarray(a, half, a.length - 1);
        x = mergesort(x);
        y = mergesort(y);
        return merge(x,y);


    }
    public static void main(String[] args) {
        int [] a = {8,3,2, 7, 5,6,4, 1, 11};
        print(a);
        quicksort(a, 0, 8);
//        a = mergesort(a);
        print(a);

    }

}
