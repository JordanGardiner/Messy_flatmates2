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
    private Connection connect = null;

    public Connection get_connection() {
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                Connection connect = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");

                    connect = DriverManager.getConnection(host,user, passwd);

                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.print(e.getErrorCode());
                    System.out.print(e.getCause());

                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                    System.out.println(e.getException());
                    System.out.print(e.getCause());
                    System.out.println("Well fuck, Class not found");

                }
                if(connect == null){
                    System.out.println("Well fuck it didn't work");
                }
                saveCon(connect);

            }
        });
        try {
            thread.start();
            thread.join();
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return get_connection();
    }
    public void saveCon(Connection connection){
        connect = connection;
    }

    public Connection getCon(){
        try{
            wait(5000);
        } catch(InterruptedException e){
            System.out.println(e.getCause());
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
