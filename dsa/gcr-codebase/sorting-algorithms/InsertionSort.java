class InsertionSort{

    public static void main(String[] args) {

        // employee id array
        int[] empId = {104, 101, 109, 102, 106};

        // insertion sort logic
        for (int i = 1; i < empId.length; i++) {

            int key = empId[i];
            int j = i - 1;

            // shifting bigger values
            while (j >= 0 && empId[j] > key) {
                empId[j + 1] = empId[j];
                j--;
            }

            // placing key at correct pos
            empId[j + 1] = key;
        }

        // printing sorted ids
        for (int i = 0; i < empId.length; i++) {
            System.out.print(empId[i] + " ");
        }
    }
}