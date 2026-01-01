class SortingComparison {

public static void main(String[] args) {

    // not too big, not too small – big enough to see timing differences
    int size = 3000;

    int[] bubbleArr = new int[size];
    int[] mergeArr  = new int[size];
    int[] quickArr  = new int[size];

    // fill arrays with same random values so comparison is fair
    for (int i = 0; i < size; i++)
        
        {

        int randomVal = (int) (Math.random() * 10000);
        bubbleArr[i] = randomVal;
        mergeArr[i]  = randomVal;
        quickArr[i]  = randomVal;
    }

    long startTime;

    long endTime;

    //bubble
    startTime = System.currentTimeMillis();
    bubbleSort(bubbleArr);
    endTime = System.currentTimeMillis();
    System.out.println("Bubble sort time: " + (endTime - startTime) + "ms");

    // marge
    startTime = System.currentTimeMillis();
    mergeSort(mergeArr, 0, size - 1);
    endTime = System.currentTimeMillis();
    System.out.println("Merge sort time  : " + (endTime -startTime) + "ms");

    //quick
    startTime = System.currentTimeMillis();
    quickSort(quickArr, 0, size - 1);
    endTime = System.currentTimeMillis();
    System.out.println("Quick sort time  : " + (endTime - startTime) + " ms");

    // might add array print here later for debugging, but skipping for now
}

// very basic bubble sort
// yeah, this is intentionally inefficient
static void bubbleSort(int[] arr) {

    for (int i = 0; i < arr.length; i++) {

        // could optimize by shrinking loop, but keeping it simple
        for (int j = 0; j < arr.length - 1; j++) {

            if (arr[j] > arr[j+1]) 
            {

                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;

            }
        }
    }
}

// merge sort recursive breakdown
static void mergeSort(int[] arr, int left, int right) {

    // base case
    if (left >= right) {
        return;
    }

    int mid = (left + right) / 2; // using simple midpoint calc

    mergeSort(arr, left, mid);
    mergeSort(arr, mid + 1, right) ;

    mergeParts(arr, left, mid, right);
}

// merging two sorted halves back together
static void mergeParts(int[] arr, int left, int mid, int right) {

    int[] temp = new int[right - left + 1];

    int i = left;


    int j = mid + 1;
    int idx = 0;

    while (i <= mid && j <= right) {
        if (arr[i] <= arr[j]) {   // <= keeps it stable
            temp[idx++] = arr[i++];

        } else {
            temp[idx++] = arr[j++];
        }
    }

    // copy leftovers (one of these will run, not both)
    while (i <= mid) {
        temp[idx++] = arr[i++];
    }

    while (j <= right) {
        temp[idx++] = arr[j++];
    }

    // copy temp back to original array
    for (int k = 0; k < temp.length; k++) 
        {
        arr[left + k] = temp[k];
    }
}

// quick sort wrapper
static void quickSort(int[] arr, int low, int high) {

    if (low < high) {

        int pivotIndex = partition (arr, low, high);

        // sort elements before and after pivot
        quickSort(arr, low, pivotIndex-1);
        quickSort(arr, pivotIndex + 1, high);
    }
}

// partition logic using last element as pivot
static int partition(int[] arr, int low,int high) {

    int pivot = arr[high];   // probably not the best pivot choice, but common
    int i = low - 1;

    for (int j = low; j < high; j++) {

        if (arr[j] < pivot) {
            i++;

            // swap arr[i] and arr[j]
            int swap = arr[i];
            arr[i] = arr[j];
            arr[j] = swap;
        }
    }

    // final pivot placement
    int swap =arr[i + 1];
    arr[i + 1]=arr[high];
    arr[high] = swap;

    return i +1;
}
}