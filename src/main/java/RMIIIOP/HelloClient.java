package RMIIIOP;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import java.util.Hashtable;
public class HelloClient {
    public static void  main( String args[] ) {
        Context ic;
        Object objref;
        HelloInterface hi;

        try {
            Hashtable env = new Hashtable();
            env.put("java.naming.factory.initial", "com.sun.jndi.cosnaming.CNCtxFactory");
            env.put("java.naming.provider.url", "iiop://127.0.0.1:1050");

            ic = new InitialContext(env);

            // STEP 1: Get the Object reference from the Name Service
            // using JNDI call.
            objref = ic.lookup("HelloService");
            System.out.println("Client: Obtained a ref. to Hello server.");

            // STEP 2: Narrow the object reference to the concrete type and
            // invoke the method.
            hi = (HelloInterface) PortableRemoteObject.narrow(
                    objref, HelloInterface.class);
            hi.sayHello( " MARS " );

        } catch( Exception e ) {
            System.err.println( "Exception " + e + "Caught" );
            e.printStackTrace( );
        }
    }
}