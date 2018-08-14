package pl.coderslab.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager{
    //singleton


    //    String connUrl = "jdbc:mysql://localhost:3306/"+dbName+"?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    static String DB_URL = "jdbc:mysql://localhost:3306/programming_School?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    static String DB_USER = "root";
    static String DB_PASS = "coderslab";


    private  static DbManager instance;
    private  static Connection connection;
    private DbManager(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static DbManager getInstance() {
        if(instance==null){
            instance=new DbManager();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {

        if(connection==null || connection.isClosed()){
            connection=DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        }
        return connection;
    }



}
