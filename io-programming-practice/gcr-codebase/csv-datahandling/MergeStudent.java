import java.io.*;
import java.util.*;

public class MergeStudent {

    public static void main(String[] args) {

        HashMap<String, String> marksMap = new HashMap<>();

        try {

            // reading students2.csv (id,marks,grade)
            Scanner sc2 = new Scanner(new FileReader("students2.csv"));

            while (sc2.hasNextLine()) {
                String line = sc2.nextLine();
                String[] parts = line.split(" , ");

                // storing marks and grade using id as key
                marksMap.put(parts[0], parts[1] + " , " + parts[2]);
            }

            sc2.close();

            // reading students1.csv (id,name,age)
            Scanner sc1 = new Scanner(new FileReader("students1.csv"));

            while (sc1.hasNextLine()) {
                String line = sc1.nextLine();
                String[] data = line.split(" , ");

                String extra = marksMap.get(data[0]);

                if (extra != null) {
                    System.out.println(
                            data[0] + " , " +
                            data[1] + " , " +
                            data[2] + " , " +extra );
                }
            }

            sc1.close();

            System.out.println("merge done");

        } catch (Exception e) {
            System.out.println("problem while merging files");
        }
    }
}