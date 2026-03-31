import java.io.*;
import java.util.*;

public class EmployeeSearchCsv {

    public static void main(String[] args) {

        String csvFile = " employeess.csv ";
        Scanner scan = new Scanner(System.in);

        System.out.print(" Enter employee  name:  ");
        String nameToFind = scan.nextLine();

        boolean isEmployeeFound = false;

        try {

            BufferedReader readerr = new BufferedReader(new FileReader(csvFile));
            String record;

            // read each line from csv
            while ((record = readerr.readLine()) != null) {

                String[] employe = record.split(" , ");

                String empName = employe[1];

                if (empName.equalsIgnoreCase(nameToFind)) {

                    System.out.println(" Employee details:");
                    System.out.println(" Department  : " +
                     employe[2]);
                    System.out.println(" Salary     : " +
                     employe[3]);

                    isEmployeeFound = true;
                    break;
                }
            }

            readerr.close();

            if (!isEmployeeFound) {
                System.out.println(" No employee found with this name. ");
            }

        } catch (Exception ex) {
            System.out.println(" Something went wrong while reading this file.");
        }

    }
}