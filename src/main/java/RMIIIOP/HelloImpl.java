package RMIIIOP;

import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;

public class HelloImpl extends PortableRemoteObject implements HelloInterface {
    public HelloImpl() throws RemoteException{
        super();
    }

    public void sayHello(String name) throws RemoteException {
        System.out.println("Hello" + name);
        System.out.flush();
    }
}
