import java.sql.*;
import java.io.*;
import java.util.*;

public class BankSQL {
    public static void main(String[] args)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/mydb";
            String username = "root";
            String password = "05Jan1999";
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            File file = new File("BankProject.sql");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while((line = reader.readLine()) != null)
            {
                statement.execute(line);
            }
            statement.close();
            conn.close();
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        catch(ClassNotFoundException exc)
        {
            exc.printStackTrace();
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
    }
}
