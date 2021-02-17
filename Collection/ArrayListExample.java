import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        al.add("Shivangi");
        al.add("Mohini");
        Iterator itr = al.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
