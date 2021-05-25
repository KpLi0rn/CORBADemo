package CORBA;

import CORBA.HelloApp.Hello;
import CORBA.HelloApp.HelloHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;


public class HelloClient {

    static Hello helloImpl;

    public static void main(String[] args) throws Exception {

        args = new String[4];
        args[0] = "-ORBInitialPort";
        args[1] = "1050";
        args[2] = "-ORBInitialHost";
        args[3] = "127.0.0.1";

        ORB orb = ORB.init(args, null);

        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        String name = "Hello-SERVER";

        helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

        System.out.println(helloImpl.sayHello());

    }
}