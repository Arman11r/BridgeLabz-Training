import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CallLog {

    private String phoneNumber;
    private String message;
    private LocalDateTime time;

    public CallLog(String phoneNumber, String message, LocalDateTime time) {
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.time = time;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "CallLog{" +
                "phoneNumber='" + phoneNumber + '\n' +
                ", message='" + message + '\n' +
                ", time=" + time +
                '}';
    }
    public static void main(String[] args) {


        List<CallLog> logs = new ArrayList<>();

        logs.add(new CallLog("9548784462", "Hello, this is arman.", LocalDateTime.now()));
        logs.add(new CallLog("9876543210", "Internet not working", LocalDateTime.now()));



        for (CallLog log : logs) {
            System.out.println(log);
        }
    }
}
