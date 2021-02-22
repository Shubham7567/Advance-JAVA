package RMIExample;

import java.rmi.*;
import java.net.*;

public class Server {
    public static void main(String[] args)
    {
        try{
            AddRemImpl locobj = new AddRemImpl();
            Naming.rebind("rmi:///AddRem", locobj);
        }
        catch(RemoteException rme)
        {
            rme.printStackTrace();
        }
        catch(MalformedURLException mfe)
        {
            mfe.printStackTrace();
        }
    }
}
