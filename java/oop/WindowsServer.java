package java.oop;

public class WindowsServer extends Server {
    public WindowsServer(String name, String ipAddress, ServerStatus status) {
        super(name, ipAddress, status);
    }

    @Override
    public void ping() {
        System.out.println("Windows ping using CMD...");
    }
}
