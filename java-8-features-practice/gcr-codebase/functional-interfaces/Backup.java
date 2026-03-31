import java.io.*;

// marker interface
interface Backupable { }


// only marked classes will be backed up
class CustomerData implements Backupable, Serializable {

    String name = "Arman";
    int id = 39;
}


public class Backup {

    public static void main(String[] args) throws Exception {

        CustomerData data = new CustomerData();

        if (data instanceof Backupable) {
            System.out.println("Backing up data");
        }
    }
}