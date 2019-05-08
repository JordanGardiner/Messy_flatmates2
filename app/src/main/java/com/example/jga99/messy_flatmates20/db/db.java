package com.example.jga99.messy_flatmates20.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {

    final private String host = "jdbc:mysql://10.196.67.154/Messy_Flatmates/";
    final private String user = "root";
    final private String passwd = "root";


    public Connection get_connection() {
        Connection connect = null;
        try {

            connect = DriverManager.getConnection(host,user, passwd);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getErrorCode());
            System.out.print(e.getCause());

        }
        if(connect == null){
            System.out.println("Well fuck it didn't work");

        }
        return connect;
    }

    public String get_All_usernames(Connection connect){
        String all_usernames = "";
        ResultSet result;
        try {


            Statement statement = connect.createStatement();
            result = statement.executeQuery("SELECT * FROM flat_user");

            while (result.next()) {
                all_usernames = all_usernames + result.getString("first_name");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return all_usernames;
    }

}
