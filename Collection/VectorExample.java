import java.util.*;
import java.io.*;

public class VectorExample {
    public static void main(String args[])
    {
        Vector<Integer> v = new Vector<>();

        for(int i=1;i<6;i++)
            v.add(i);
        
        System.out.println(v);

        v.remove(3);
        System.out.println(v);
        for(int i=0;i<v.size();i++)
            System.out.println(v.get(i) + " ");
    }
}
