import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    private String userName = "root@localhost";
    private String password = "";
    private String nameDataBase = "demo";
    private String host = "localhost";
    private int port = 8889;
    private Connection con=null;

    public Connect(){
        String url="jdbc:mysql://"+host+":"+port+"/"+nameDataBase;
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not found ");
        }
        try {
            con =DriverManager.getConnection(url,userName,password);
            System.out.println("Connection with Database is successful");
        } catch (SQLException e) {
            //System.out.println("Connection with Database is unsuccessful");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Connect connect=new Connect();


    }



}
