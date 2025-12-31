class TaskNode {
    int id;
    String name;
    int priority;
    TaskNode next;

    //tasknode heere
    TaskNode(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }
}
//linked list code
public class CircularTaskList {

    TaskNode head = null;

    // add task
    public void addTask(int id, String name, int priority)
     {

        TaskNode node = new TaskNode(id, name, priority);

        if (head == null) {
            head = node;
            node.next = head;
            return;
        }


        TaskNode temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = head;
    }

    // display tasks
    public void displayTasks() {
        if (head == null) return;

        TaskNode temp = head;
        do {
            System.out.println(temp.id + " " + temp.name);
            temp = temp.next;
        } while (temp != head);
    }
//main method
    public static void main(String[] args) {
        CircularTaskList list = new CircularTaskList();
        list.addTask(1, "Study hard", 1);
        list.addTask(2, "Code more", 2);

        list.displayTasks();
    }
}