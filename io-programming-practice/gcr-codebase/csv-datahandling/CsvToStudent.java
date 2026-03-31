import java.io.*;
import java.util.*;

class Student {

    int id;
    String name;
    int age;

    Student(int i, String n, int a) {
        id = i;
        name = n;
        age = a;
    }

    void printStudent() {
        System.out.println(id + " " + name + " " + age);
    }
}

public class CsvToStudent {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader("students.csv"));
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int sid = Integer.parseInt(data[0]);
                String sname = data[1];
                int sage = Integer.parseInt(data[2]);

                Student st = new Student(sid, sname, sage);
                list.add(st);
            }

            br.close();

            // printing all students
            for (int i = 0; i < list.size(); i++) {
                list.get(i).printStudent();
            }

        } catch (Exception e) {
            System.out.println(" problem while reading csv .");
        }
    }
}