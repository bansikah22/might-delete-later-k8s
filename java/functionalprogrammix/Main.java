package java.functionalprogrammix;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Server> servers = List.of(
            new Server("Server A", "192.168.1.1", ServerStatus.UP),
            new Server("Server B", "192.168.1.2", ServerStatus.DOWN),
            new Server("Server C", "192.168.1.3", ServerStatus.UP),
            new Server("Server D", "192.168.1.4", ServerStatus.PENDING),
            new Server("Server E", "192.168.1.5", ServerStatus.UP)
        );

        // 1. Filter servers that are UP
        System.out.println("--- UP Servers ---");
        servers.stream()
            .filter(server -> server.getStatus() == ServerStatus.UP)
            .forEach(server -> System.out.println(server.getName()));

        // 2. Get the names of the UP servers
        System.out.println("\n--- UP Server Names ---");
        List<String> upServerNames = servers.stream()
            .filter(server -> server.getStatus() == ServerStatus.UP)
            .map(server -> server.getName())
            .collect(Collectors.toList());
        System.out.println(upServerNames);

        // 3. Count the number of UP servers
        System.out.println("\n--- Number of UP Servers ---");
        long upServerCount = servers.stream()
            .filter(server -> server.getStatus() == ServerStatus.UP)
            .count();
        System.out.println(upServerCount);

        // 4. Ping all UP servers
        System.out.println("\n--- Pinging UP Servers ---");
        servers.stream()
            .filter(server -> server.getStatus() == ServerStatus.UP)
            .forEach(Server::ping);
    }
}
