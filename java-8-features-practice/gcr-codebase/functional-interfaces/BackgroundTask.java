public class BackgroundTask {

    public static void main(String[] args) {

        Runnable job = () -> {
            System.out.println("Task running in background");
        };

        Thread t = new Thread(job);
        t.start();
    }
}