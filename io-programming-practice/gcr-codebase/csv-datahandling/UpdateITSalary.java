import java.io.*;

public class UpdateITSalary {

    public static void main(String[] args) {

        String inputFile = "employee.csv";
        String outputFile = "employee_new_data_updated.csv";

        try {

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            FileWriter fw = new FileWriter(outputFile);

            String line;

            while ((line = br.readLine()) != null) {

                String[] empData = line.split(",");

                String id = empData[0];
                String name = empData[1];
                String dept = empData[2];
                double salary = Double.parseDouble(empData[3]);

                // increase salary only for IT department here by 10
                if (dept.equalsIgnoreCase("IT")) {
                    salary = salary + salary * 0.10;
                }

                fw.write(id + "," + name + "," + dept + "," + salary);
                fw.write("\n");
            }

            br.close();
            fw.close();

            System.out.println("CSV file updated");

        } catch (Exception e) {
            System.out.println("Something went wrong while updating file");
        }
    }
}