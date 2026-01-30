package java.interfacevsabstact.interfaces.notifier;

public class Main {
    public static void main(String[] args) {
        Notification notifier = new NotifierService();
        notifier.sendNotification("Hello, this is a test notification!");
    }
}
