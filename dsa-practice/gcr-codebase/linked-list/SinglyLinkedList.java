class StudentNode {
    int roll;
    String name;
    int age;
    char grade;
    StudentNode next;

    // constructor for student node
    StudentNode(int roll, String name, int age, char grade) {
        this.roll = roll;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null; // next is empty first
    }
}

public class SinglyLinkedList {

    StudentNode head; // starting node

    // add at end
    public void addStudent(int roll, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(roll, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // delete student by roll no
    public void deleteStudent(int roll) {
        if (head == null) return;

        if (head.roll == roll) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.roll != roll) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // search student
    public void searchStudent(int roll) {
        StudentNode temp = head;
        while (temp != null) {
            if (temp.roll == roll) {
                System.out.println("Found : " + temp.name);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found. ");
    }

    // update grade
    public void updateGrade(int roll, char newGrade) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.roll == roll) {
                temp.grade = newGrade;

                return;
            }
            temp = temp.next;
        }
    }

    // display all students
    public void display() {
        StudentNode temp = head;

        while (temp != null) {

            System.out.println(temp.roll + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.addStudent(1, "Arman", 22, 'A');
        list.addStudent(2, "Aman", 21, 'B');
        list.display();

        list.updateGrade(2, 'A');
        list.searchStudent(2);
        list.deleteStudent(1);

        list.display();
    }
}