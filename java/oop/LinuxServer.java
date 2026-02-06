package java.oop;
/*
@LinuxServer extends Server which is an abstract class
@constructor takes name, ip address and status as arguments
and you can notice that we use the **super keyword to extend the parent class
that way we avoid repeating the same code , if we have addition attributes in this class
that is when we can add them and use the this.newAttribute = newAttribute
@overrides ping() method

*/

public class LinuxServer extends Server {

    public LinuxServer(String name, String ipAddress, ServerStatus status) {
        super(name, ipAddress, status);
    }

    @Override
    public void ping() {
        System.out.println("Pinging Linux Server");
    }

    
}
