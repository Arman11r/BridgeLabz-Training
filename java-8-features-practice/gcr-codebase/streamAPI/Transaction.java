import java.time.*;
import java.util.*;

public class Transaction {

    public static void main(String[] args) {

        List<String> transactionIds = Arrays.asList("100", "101", "102", "103");
        transactionIds.forEach(id -> {
            System.out.println(LocalDateTime.now() + " Transaction: " + id);
        });
    }
}