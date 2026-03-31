import java.io.*;
public class CsvBatchReader {

    public static void main(String[] args) {

        int totalLines = 0;
        int group = 1;

        String fileName = "large_dataset.csv";
        BufferedReader br = null;

        try {

            br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {

                totalLines++;

                // print message for every 100 rec
                if (totalLines % 100 == 0) {
                    System.out.println(
                        "Batch " + group + " completed (" + totalLines + " lines read)"
                    );
                    
                    group++;
                }
            }

            System.out.println("Finished reading file");
            System.out.println("Total lines read: " + totalLines);

        } catch (Exception e) {
            System.out.println("Could not process the CSV file");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing file");
            }
        }
    }
}