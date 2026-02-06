package java.oop;

/*
- We use abstract class here so that all kinds of servers will implement the 
 MUST methods found inside the abstract class
- Abstract class cannot be instantiated but can be inherited
- All subclasses must implement ALL abstract methods, otherwise they cannot be instantiated
- If a subclass does not implement ALL abstract methods, it is still an abstract class
*/

public abstract class Server {
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

    public String ipAddress(){
        return ipAddress;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public abstract void ping();

    @Override
    public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof Server)) return false;
       Server server = (Server) o;
       return ipAddress.equals(server.ipAddress);
    }

    @Override
    public int hashCode() {
      return ipAddress.hashCode();
    }  
}
