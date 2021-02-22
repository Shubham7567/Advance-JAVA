package RMIExample;

import java.rmi.*;

public class MyClient {
    public static void main(String[] args){
        try{
            Adder stub = (Adder)Naming.lookup("rmi://localhost:5000/mcaiv");
            System.out.println(stub.add(4, 5));
        }catch(Exception ex)
        {
            ex.printStackTrace(System.err);
        }
    }
}
