import java.io.*;

public class BufferedFileCopy {

    public static void main(String[] args) {

        String input = "file.txt";
        String out = "fileCopy.txt";

        byte[] buffer = new byte[4096];

        // unbuffered here
        try {
            long start = System.nanoTime();

            FileInputStream fi = new FileInputStream(input);
            FileOutputStream fo = new FileOutputStream(out);

            int bytes;
            while ((bytes = fi.read(buffer)) != -1) {
                fo.write(buffer, 0, bytes);
            }

            long end = System.nanoTime();
            System.out.println("unbuffered time: " + (end - start));

            fi.close();
            fo.close();

        } catch (IOException e) {
            System.out.println("error in unbuffered copy");
        }

        // buffered copy
        try {
            long start = System.nanoTime();

            BufferedInputStream bi = new BufferedInputStream(new FileInputStream(input));
            BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(out));

            int bytes;
            while ((bytes = bi.read(buffer)) != -1) {
                bo.write(buffer, 0, bytes);
            }

            bo.flush();
            long end = System.nanoTime();
            System.out.println("buffer time: " + (end-start));

            bi.close();
            bo.close();

        } catch (IOException e) {
            System.out.println("error");
        }
    }
}