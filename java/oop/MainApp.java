package java.oop;

import java.util.HashSet;
import java.util.Set;

public class MainApp {
    public static void main(String[] args) {
        // Server server = new LinuxServer("Linux Server", "237.84.2.178", ServerStatus.UP);
      

        LinuxServer linuxServer = new LinuxServer("Linux Server 2", "237.84.2.179", ServerStatus.DOWN);
        //test duplicate
        LinuxServer duplicate = new LinuxServer("Linux Server 3", "237.84.2.179", ServerStatus.UP);

        WindowsServer windowsServer = new WindowsServer("Windows Server", "237.84.2.180", ServerStatus.UP);
  
        Set<Server> servers = new HashSet<>();
        servers.add(linuxServer);
        servers.add(windowsServer);
        servers.add(duplicate);
        
        for(Server server : servers) {
            server.ping();
        }
    }
}
