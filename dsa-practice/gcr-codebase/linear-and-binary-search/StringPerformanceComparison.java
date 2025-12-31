public class StringPerformanceComparison {

    public static void main(String[] args) {

        int times = 1_000_000; //example time taken here for the question

        // StringBuilder created here and appened hello in it
        long start1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append("hello");
        }
        //printing time
        long end1 = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (end1 - start1) + " ms");

        // StringBuffer buffer created here and appened hello in it
        long start2 = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < times; i++) {
            buffer.append("hello");
        }
        //printing time
        long end2 = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (end2 - start2) + " ms");
    }
}