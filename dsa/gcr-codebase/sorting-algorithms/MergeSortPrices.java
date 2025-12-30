class MergeSortPrices {

    public static void main(String[] args) {

        // book prices
        int[] prices = {450, 120, 300, 200, 150};

        mergeSort(prices, 0, prices.length - 1);

        // printing sorted prices
        for (int value : prices) {
            System.out.print(value + " ");
        }
    }

    // merge sort method
    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            // sorting left half
            mergeSort(arr, left, mid);

            // sorting right half
            mergeSort(arr, mid + 1, right);

            // merging both halves
            merge(arr, left, mid, right);
        }
    }

    // merge logic
    static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        // copying values
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        // merging arrays
        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // remaining elements
        while (i < n1) {
            arr[k++] = L[i++];
        }

        while (j < n2) {
            arr[k++] = R[j++];
        }
    }
}