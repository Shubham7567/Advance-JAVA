package RMIExample;

import java.rmi.*;
public interface AddRem extends Remote{
    public int add(int a, int b) throws RemoteException;
}