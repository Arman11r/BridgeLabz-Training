
    public class SearchComparison {

        public static void main(String[] args) {
            // created an array here named numbers and defined size 100000

            int size = 100000;
            int[] numbers = new int[size];


            // filling array with values
            for (int i = 0; i < size; i++)
                {

                numbers[i] = i;
            }
            //target-1

            int target = size - 1;

            // linear search time
            long start = System.nanoTime () ;
            linear(numbers, target);

            long end = System.nanoTime();
            System.out.println("linear search time:  " + (end - start));//print

            // binary search time

            start = System.nanoTime ();

            binari(numbers, target);

            end = System.nanoTime();

            System.out.println("binary search time: " + (end  - start));//print here
        }

        // checks each element one by one
        static int linear(int[] arr, int key) {

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == key) return i;
            }
            return -1;
        }

        // search using middle logic
        static int binari(int[] arr, int key) {
            int lower = 0, higher = arr.length - 1;

            while (lower <= higher) {
                int middl = (lower + higher) / 2;

                if (arr[middl] == key) return middl;
                if (arr[middl] < key) lower = middl + 1 ;

                else higher = middl     - 1;
            }
            return -1;//if false
        }
    }