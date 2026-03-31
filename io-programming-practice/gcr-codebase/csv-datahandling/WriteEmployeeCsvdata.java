import java.io.*;

public class WriteEmployeeCsvdata {

    public static void main(String[ ]  args) {

        String sample = " employeesampledata.csv "; //sample data file only

        try {

            FileWriter w = new FileWriter(sample); //using inbuilt FileWriter class to add data to it

            // writing employee records
            w.write("1,Bhaskar,HR,45000\n");
            w.write("2,Arman,CEO,52000\n");
            w.write("3,Kartik,IT,60000\n");
            w.write("4,Rachit,Marketing,48000\n");
            w.write("5,Amit,Support,35000\n");

            w.close();
 
            System.out.println(" Employee data successfully written in csv file. ");

        } catch (Exception e) {
            System.out.println("  Error while wrting the data in the csv file.  ");
        }
    }
}