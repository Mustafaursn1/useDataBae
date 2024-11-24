import java.sql.*;

public class Connect {
    private String userName = "root";
    private String password = "";
    private String nameDataBase = "demo";
    private String host = "localhost";
    private int port = 3306;
    private Connection con = null;
    private Statement statement = null;


    public void getEmployee() {
        String query = "Select * from employees ";
        try {
            statement =con.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
           ResultSet rs= statement.executeQuery(query);
           while (rs.next()){
               int id=rs.getInt("id");
               String name=rs.getString("firstname");
               String lastName=rs.getString("lastname");
               String email=rs.getString("email");
               System.out.println("Id: "+id+"name: "+name+"lastname: "+lastName+"email: "+email);
           }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connect() {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + nameDataBase;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver is not found ");
        }
        try {
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Connection with Database is successful");
        } catch (SQLException e) {
            //System.out.println("Connection with Database is unsuccessful");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.getEmployee();


    }


}
