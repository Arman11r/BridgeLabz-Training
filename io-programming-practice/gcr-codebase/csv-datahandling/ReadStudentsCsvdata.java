import java.io.*;

public class ReadStudentsCsvdata {

    public static void main(String[] args) {

        String fileName = " studentsexampledata.csv ";

        try {

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";

            while ((line = br.readLine()) != null) {

                String info[] = line.split(",");

                System.out.println(
                        "Student ID : " + info[0] +
                        " | Name : " + info[1] +
                        " | Age : " + info[2] +
                        " | City : " + info[3]
                );
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Problem while reading data");
        }
    }
}