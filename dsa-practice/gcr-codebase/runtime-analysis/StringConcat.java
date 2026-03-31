public class StringConcat {
// comparing string , stringbuilder and stringbuffer performance
    public static void main(String[] args) {

        int n = 100000;   // you can change this to 1000 / 10000 / 1000000
// variables to store time
        long start, end;

          // string
        String str = "";
        start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            str = str + "a";   // creates new object every time
        }

// print time here
        end = System.currentTimeMillis();
        //output time here
        System.out.println("String time : " + (end - start) + " ms");



        // stringbuulder
        StringBuilder sb = new StringBuilder();
        start = System.currentTimeMillis();


        for (int i = 0; i < n; i++) {
            sb.append("a");   // same object, faster
        }


        end = System.currentTimeMillis();
        //output time here

        System.out.println("StringBuilder time : " + (end - start) + " ms");


        //StringBuffer

            StringBuffer sbf = new StringBuffer();
        start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            sbf.append("a");   // thread safe but little slow
        }

        // print time here

          end = System.currentTimeMillis();
        //output time here
        System.out.println("StringBuffer time : " + (end - start) + " ms");
    }// End of main
}// End of class