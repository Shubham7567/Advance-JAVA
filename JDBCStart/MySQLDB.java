import java.io.*;
import java.sql.*;
import java.util.*;

public class MySQLDB {
    public static void main(String[] args)
    {
        try{
            Scanner sc = new Scanner(System.in);
            File file = null;
            if(args.length > 0)
            {
                file = new File(args[0]);
            }else{
                System.out.println("Enter filename:");
                file = new File(sc.next());
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line="";
            while((line = reader.readLine()) != null)
            {
                if(line != "")
                {
                    if(line.startsWith("select") || line.startsWith("Select"))
                    {
                        ExecuteDML(line);
                    }
                    else
                    {
                        ExecuteDDL(line);
                    }
                }
            }

        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
    }

    public static void ExecuteDML(String sql)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for(int index=1;index<columnCount;index++)
            {
                if(index > 1) System.out.print(", ");
                System.out.print(metaData.getColumnLabel(index));
            }
            System.out.println();
            while(rs.next())
            {
                for(int i =1;i<=columnCount;i++)
                {
                    if(i > 1) System.out.print(", ");
                    System.out.print(rs.getString(i));
                }
                System.out.println();
            }
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }

    public static void ExecuteDDL(String sql)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
            System.out.println(statement.getUpdateCount() + " rows updated");
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }
        catch(ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection("jdbc:mysql://localhost/Practice","root","05Jan1999");
    }
}