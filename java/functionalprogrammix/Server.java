package java.functionalprogrammix;

public class Server {
    private String name;
    private String ipAddress;
    private ServerStatus status;

    public Server(String name, String ipAddress, ServerStatus status) {
        this.name = name;
        this.ipAddress = ipAddress;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public void ping() {
        System.out.println("Pinging " + name + " at " + ipAddress);
    }
}
