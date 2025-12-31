class HeapSortSalary {

    public static void main(String[] args) {

        // salary demands
        int[] salary = {40000, 25000, 60000, 30000, 52000};

        int n = salary.length;

        // build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salary, n, i);
        }

        // extract elements
        for (int i = n - 1; i > 0; i--) {

            int temp = salary[0];
            salary[0] = salary[i];
            salary[i] = temp;

            heapify(salary, i, 0);
        }

        // printing sorted salary
        for (int value : salary) {
            System.out.print(value + " ");
        }
    }

    // heapify method
    static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}