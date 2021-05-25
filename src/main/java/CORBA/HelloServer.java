package CORBA;

import CORBA.HelloApp.Hello;
import CORBA.HelloApp.HelloHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;


public class HelloServer {
    public static void main(String[] args) throws InvalidName, AdapterInactive, ServantNotActive, WrongPolicy, org.omg.CosNaming.NamingContextPackage.InvalidName, NotFound, CannotProceed {
        args = new String[4];
        args[0] = "-ORBInitialPort";
        args[1] = "1050";
        args[2] = "-ORBInitialHost";
        args[3] = "127.0.0.1";

        ORB orb = ORB.init(args, null);

        POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
        rootpoa.the_POAManager().activate();

        HelloImpl HelloImpl = new HelloImpl();
        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(HelloImpl);
        Hello hellpRef = HelloHelper.narrow(ref);

        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        NameComponent path[] = ncRef.to_name("Hello-SERVER");
        ncRef.rebind(path, hellpRef);

        System.out.println("Server ready and waiting...");

        orb.run();
    }
}
