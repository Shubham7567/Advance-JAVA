import java.util.*;

public class LinkListExample {
    public static void main(String[] args)
    {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("Shubham");
        ll.add("Devangi");
        ll.add("Shubhuu");
        ll.add("Shubham");
        Iterator<String> itr = ll.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}
