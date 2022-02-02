package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/?newtesting";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: "+ jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection Successfull !!!");

        }catch (Exception exc){
            exc.printStackTrace();
        }
    }



}
