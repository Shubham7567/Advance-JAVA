package exec;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

import javax.xml.catalog.Catalog;

import java.sql.*;

public class ExecSQL
{
    public static void main(String[] args) throws IOException
    {
        try(Scanner in = args.length == 0 ? new Scanner(System.in) : new Scanner(Paths.get(args[0]),StandardCharsets.UTF_8))
        {
            try(Connection conn = getConnection(); Statement stat = conn.createStatement())
            {
                while(true)
                {
                    if(args.length == 0)
                    {
                        System.out.println("Enter command or EXIT to exit");
                    }
                    if(!in.hasNext())
                        return;
                    String line = in.nextLine().trim();
                    if(line.equalsIgnoreCase("EXIT")) return;
                    if(line.endsWith(";")) //remove trailing semicolon
                        line = line.substring(0, line.length() - 1);
                    try{
                        ResultSet rs = null;
                        if(line.startsWith("SELECT") || line.startsWith("select") || line.startsWith("Select"))
                        {
                            rs = stat.executeQuery(line);
                        }
                        else{
                            System.out.println("Testing");
                            stat.executeUpdate(line);
                            int updateCount = stat.getUpdateCount();
                            System.out.println(updateCount + " rows updated");
                        }
                        if(rs != null)
                        {
                            try
                            {
                                showResultSet(rs);
                            }
                            catch(Exception ex)
                            {
                                ex.printStackTrace();
                            }
                        }
                    }
                    catch(SQLException e)
                    {
                        for(Throwable t : e)
                            t.printStackTrace();
                    }
                }
            }
        }
        catch(SQLException e)
        {
            for(Throwable t : e)
                t.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException,IOException
    {
        try
        {
        var props = new Properties();
        // try(InputStream in = Files.newInputStream(Paths.get("database.Properties")))
        // {
        //     props.load(in);
        // }
        // String drivers = props.getProperty("jdbc.drivers");
        // if(drivers != null)
        //     System.setProperty("jdbc.driver",drivers);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost/mydb";
        String username = "root";
        String password = "05Jan1999";
        return DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException exc)
        {
            exc.printStackTrace();
        }
        return null;
    }
    public static void showResultSet(ResultSet result)throws SQLException
    {
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
    }
}