import java.sql.*;

public class StoredProcedureCallExample {
    public static void main(String[] args)
    {
        String dbUrl = "jdbc:mysql://localhost/mydb";
        String user = "root";
        String password = "05Jan1999";
        try{
            Connection con = DriverManager.getConnection(dbUrl, user, password);
            CallableStatement statement = con.prepareCall("{call create_author(?,?)}");
            statement.setString(1,"Bill Gates");
            statement.setString(2,"bill@microsoft.com");
            statement.execute();
            statement.close();
            con.close();
            System.out.println();
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
