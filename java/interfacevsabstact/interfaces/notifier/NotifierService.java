package java.interfacevsabstact.interfaces.notifier;

public class NotifierService implements Notification {
    @Override
    public void sendNotification(String message) {
        System.out.println("Notification sent: " + message);
    }

}
