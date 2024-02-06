public class App {
    private SmsApi smsApi;
    private WhatsAppApi whatsAppApi;
    private MessengerApi messengerApi;

    public App(SmsApi smsApi, WhatsAppApi whatsAppApi, MessengerApi messengerApi) {
        this.smsApi = smsApi;
        this.whatsAppApi = whatsAppApi;
        this.messengerApi = messengerApi;
    }

    public void notifyCustomer(Customer customer) {
        String message = generateMessage(customer);

        switch (customer.messagePreference) {
            case SMS:
                sendSMS(message, customer.phoneNumber);
                break;
            case WhatsApp:
                sendWhatsApp(message, customer.phoneNumber);
                break;
            case Messenger:
                sendMessenger(message, customer.userName);
                break;
            default:
                System.out.println("Unsupported message preference");
                break;
        }
    }

    private String generateMessage(Customer customer) {
        String greeting = "Hi " + customer.customerName + ",";
        String orderReadyMessage = "Your order is ready to collect.\nHave a nice day.";

        return customer.messagePreference == MessagePreference.SMS
                ? customer.customerName + ", Your Order is ready."
                : greeting + "\n" + orderReadyMessage;
    }

    private void sendSMS(String message, String phoneNumber) {
        smsApi.send(message, phoneNumber);
    }

    private void sendWhatsApp(String message, String phoneNumber) {
        whatsAppApi.send(message, phoneNumber);
    }

    private void sendMessenger(String message, String username) {
        messengerApi.send(message, username);
    }
}