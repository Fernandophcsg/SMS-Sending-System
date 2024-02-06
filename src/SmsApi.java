public class SmsApi {
    public void send(String message, String phoneNumber) {
        System.out.println("Sending SMS to " + phoneNumber + ": \n" + message);
    }
}
