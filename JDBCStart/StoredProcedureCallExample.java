import java.sql.*;

public class StoredProcedureCallExample {
    public static void main(String[] args)
    {
        String dbUrl = "jdbc:mysql://localhost/mydb";
        String user = "root";
        String password = "05Jan1999";
        try{
            Connection con = DriverManager.getConnection(dbUrl, user, password);
            CallableStatement statement = con.prepareCall("{call create_author_v3(?,?)}");
            statement.setString(1,"Jeff Bezos");
            statement.setString(2,"jezzbefoz@aws.com");
            ResultSet result = statement.executeQuery();
            ResultSetMetaData metaData = result.getMetaData();
            int columnCount = metaData.getColumnCount();
            for(int i=1;i <= columnCount;i++)
            {
                if(i > 1) System.out.print(", ");
                System.out.print(metaData.getColumnLabel(i));
            }
            System.out.println();
            while(result.next())
            {
                for(int i =1;i<=columnCount;i++)
                {
                    if(i > 1) System.out.print(", ");
                    System.out.print(result.getString(i));
                }
                System.out.println();
            }
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
