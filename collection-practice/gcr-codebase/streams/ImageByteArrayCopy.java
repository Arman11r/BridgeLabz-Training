import java.io.*;

public class ImageByteArrayCopy {

    public static void main(String[] args) {

        String sourceImage = "image.jpg";
        String newImage = "image_copy.jpg";

        try {
            FileInputStream fileinput = new FileInputStream(sourceImage);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int data;
            while ((data = fileinput.read()) != -1) {
                byteArrayOutputStream.write(data);
            }

            byte[] imageBytes = byteArrayOutputStream.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fileoutput = new FileOutputStream(newImage);

            while ((data = bais.read()) != -1) {
                fileoutput.write(data);
            }

            fileinput.close();
            fileoutput.close();

            System.out.println("image copied succesfully using the byte array");

        } catch (IOException e) {
            System.out.println("image read write error");
        }
    }
}