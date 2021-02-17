package test;

import java.nio.file.*;
import java.sql.*;
import java.io.*;
import java.lang.Thread.State;
import java.util.*;

/*
This program tests that the database and the JDBC driver are correctly configured.
@version 1.03 2018-05-01
@author Cay Horstmann
*/

public class TestDB
{
    public static void main(String[] args) throws IOException
    {
        try{
            RunTest();
        }catch(SQLException exc)
        {
            for(Throwable t : exc)
                t.printStackTrace();
        }
        catch(ClassNotFoundException exc)
        {
            exc.printStackTrace();
        }
    }
    /*
    Runs a test by creating a table, adding value, showing table content
    removing table
    */
    public static void RunTest() throws SQLException,IOException,ClassNotFoundException
    {
        try(Connection con = getConnection(); Statement stat = con.createStatement())
        {
            Class.forName("com.mysql.jdbc.Driver");
            String query = "Create Table Book(BookID int PRIMARY KEY,BookName varchar(20),Author varchar(20));";
            stat.executeUpdate(query);
            stat.close();
            con.close();
        }
        catch(ClassNotFoundException exc)
        {
            exc.printStackTrace();
        }
    }

    //get the connection
    public static Connection getConnection() throws SQLException,IOError
    {
        var props = new Properties();
        try(InputStream in = Files.newInputStream(Paths.get("database.properties")))
        {
            props.load(in);
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
        String drivers = props.getProperty("jdbc.drivers");

        if(drivers != null)
        {
            System.setProperty("jdbc.drivers", drivers);
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            System.out.println(url + " " + username + " " + password);
            return DriverManager.getConnection(url, username, password);
        }
        return null;
    }
}