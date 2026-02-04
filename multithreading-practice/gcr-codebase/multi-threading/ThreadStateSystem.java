class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    public void run() {

        try {
            Thread.sleep(2000); 
        } catch (Exception e) {}

        for (int i = 0; i < 1000000; i++) {}
    }
}

class StateMonitor extends Thread {

    private Thread t1, t2;

    public StateMonitor(Thread a, Thread b) {
        t1 = a;
        t2 = b;
    }

    public void run() {

        boolean running = true;

        while (running) {

            System.out.println("[Monitor] "
                    + t1.getName() + " -> " + t1.getState()
                    + " | " + t2.getName() + " -> " + t2.getState());

            if (t1.getState() == Thread.State.TERMINATED &&
                t2.getState() == Thread.State.TERMINATED) {
                running = false;
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }

        System.out.println("Monitoring finished.");
    }
}

public class ThreadStateSystem {

    public static void main(String[] args) {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        StateMonitor monitor = new StateMonitor(t1, t2);

        monitor.start();
        t1.start();
        t2.start();
    }
}