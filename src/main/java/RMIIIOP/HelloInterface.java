package RMIIIOP;

import java.rmi.Remote;

public interface HelloInterface extends Remote {
    public void sayHello(String name) throws java.rmi.RemoteException;
}
