class Solution {
    int merge(int[] arr, int l, int mid, int r) {
        int count = 0;
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        int n1 = mid - l + 1;
        int n2 = r - mid;    // r - (mid + 1) + 1
        
        // create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // copy data to temp arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[l+i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid+1+j];
            
        /* Code to count reverse pairs */
        int j = 0;
        for (int i = 0; i < n1; i++) {
            while (j < n2 && L[i] > (2 * (long)R[j]))
                j++;
            count += j;
        }
        
        // Merge temp arrays
        int i = 0, k = (int)l; j = 0;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];

            else
                arr[k++] = R[j++];
        }
        
        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
        
        return count;
    }
    int mergeSort(int[] arr, int l, int r) {
        if (l >= r) return 0;
        
        int mid = l + (r-l)/2;

        int count = mergeSort(arr, l, mid);
        count += mergeSort(arr, mid+1, r);

        count += merge(arr, l, mid, r);
        
        return count;
    }
    public int reversePairs(int[] arr) {
        return mergeSort(arr, 0, arr.length-1);
    }
}