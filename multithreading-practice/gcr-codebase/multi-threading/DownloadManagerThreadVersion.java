class FileDownloaderThread extends Thread {

    private String fileName;

    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {


        for (int progress = 0; progress <= 100; progress += 10) {

            System.out.println(getName() + "=> Downloading "
                    + fileName + ": " + progress + "%");

            try {
                Thread.sleep(200); 
            } catch (InterruptedException e) {
                System.out.println("Download interrupted");
            }
        }

        System.out.println(getName() + "=> " + fileName + " completed.");
    }
}

public class DownloadManagerThreadVersion {

    public static void main(String[] args) throws Exception {

        FileDownloaderThread t1 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t2 = new FileDownloaderThread("Image.jpg");
        FileDownloaderThread t3 = new FileDownloaderThread("Video.mp4");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All downloads complete!");
    }
}