import java.util.*;

public class Main {
    public static void main(String[] args) {
        SmsApi smsApi = new SmsApi();
        WhatsAppApi whatsAppApi = new WhatsAppApi();
        MessengerApi messengerApi = new MessengerApi();

        App app = new App(smsApi, whatsAppApi, messengerApi);

        Customer customer = new Customer();

        customer.customerId = 2;
        customer.customerName = "Chiran Sooryakumara";
        customer.messagePreference = MessagePreference.Messenger;
        customer.phoneNumber = "0771239143";
        customer.userName = "chiran";

        app.notifyCustomer(customer);



    }

    

}


