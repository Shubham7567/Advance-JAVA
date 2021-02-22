package RMIExample;

import java.net.*;
import java.rmi.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String[] args)
    {
        try
        {
            String host = "localhost";
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 1st number:");
            int a = sc.nextInt();
            System.out.println("Enter 2nd number:");
            int b = sc.nextInt();
            AddRem remobj = (AddRem)Naming.lookup("rmi://"+ host+"/AddRem");
            System.out.println(remobj.add(a, b));
        }
        catch(RemoteException rme)
        {
            rme.printStackTrace();
        }
        catch(NotBoundException nbe)
        {
            nbe.printStackTrace();
        }
        catch(MalformedURLException mfe)
        {
            mfe.printStackTrace();
        }
    }
}
