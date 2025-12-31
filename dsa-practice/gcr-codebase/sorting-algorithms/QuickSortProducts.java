class QuickSortProducts {

    public static void main(String[] args) {

        // product prices
        int[] prices = {900, 300, 700, 100, 500};

        quickSort(prices, 0, prices.length - 1);

        // printing sorted prices

        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
    }

    // quick sort method
    static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            // sort left side
            quickSort(arr, low, pi - 1);

            // sort right side
            quickSort(arr, pi + 1, high);
        }
    }

    // partition logic
    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) 
            {

            if (arr[j] < pivot) {

                i++;
                int temp = arr[i];

                arr[i] = arr[j];
                arr[j] = temp;

            }
        }

        int temp = arr[i + 1];

        arr[i + 1] = arr[high];
        arr[high] = temp;


        return i + 1;
    }
}
