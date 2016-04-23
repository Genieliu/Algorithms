public class MyMergeSort {
    public static void mergesort(int[] arr){
        submergesort(arr,0,arr.length-1);
    }
    public static void submergesort(int[] arr,int p, int r) {
        if(p<r) {
            int q = (p+r)/2;
            submergesort(arr,p,q);
            submergesort(arr,q+1,r);
            merge(arr,p,q,r);
        }
    }

    public static void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L1 = new int[n1];
        int[] L2 = new int[n2];

        for (int i = 0; i < n1; i++)
            L1[i] = arr[p + i];

        for (int i = 0; i < n2; i++)
            L2[i] = arr[q + 1 + i];

        int i = 0;
        int j = 0;
        int k = p;
        for (; k < r + 1; k++)
            if (i < n1 && j < n2) {
                if (L1[i] <= L2[j]) {
                    arr[k] = L1[i];
                    i++;
                } else {
                    arr[k] = L2[j];
                    j++;
                }
            } else if (i < n1 && j >= n2) {
                arr[k] = L1[i];
                i++;
            } else {
                arr[k] = L2[j];
                i++;
            }
    }
}
