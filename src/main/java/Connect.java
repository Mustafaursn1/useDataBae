import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class Connect {
    private String userName = "root";
    private String password = "";
    private String nameDataBase = "demo";
    private String host = "localhost";
    private int port = 8888;
    private Connection con;
    private Statement statement;

    public void deleteEmployee(){
        try {
            statement=con.createStatement();
            String query="Delete from employees where id>3";
           int i= statement.executeUpdate(query);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateEmployee() {

        try {
            statement= con.createStatement();
            String query="Update employees Set email ='tk.12@hotmail.com' where id=1";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee() {
        try {
            statement = con.createStatement();
            String fristName = "Semih";
            String lastName = "Akkoyun";
            String email = "smh.2020@gmail.com";
            String query = "insert into employees (firsname,lastname,email) VALUES (" + "'" + fristName + "'," + lastName + "'," + email + ",)";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getEmployee() {
        String query = "Select * from employees ";
        try {
            statement = con.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                System.out.println("Id: " + id + "name: " + name + "lastname: " + lastName + "email: " + email);
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
            con = getConnection(url, userName, password);
            System.out.println("Connection with Database is successful");
        } catch (SQLException e) {
            //System.out.println("Connection with Database is unsuccessful");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Connect connect = new Connect();
        connect.getEmployee();

        System.out.println("before.....");
        connect.addEmployee();

        connect.updateEmployee();
        connect.deleteEmployee();


    }


}
