import java.sql.*;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public  class Connect {
    private static String userName = "root";
    private static String password = "";
    private static String nameDataBase = "demo";
    private static String host = "localhost";
    private static int port = 8888;
    private static Connection con =null;
    private static Statement statement=null;
    private static PreparedStatement preparedStatement=null;
    public static void getPrepairedEmployee(int id){
        try {
            String query="Select *From empployees where id>? and firstname like ? ";
            preparedStatement=con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,"M%");
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                String firstname=rs.getString("firstname");
                String lastname=rs.getString("lastname");
                String email=rs.getString("email");
                System.out.println("firstname:"+firstname+"lastname: "+lastname+"email:"+email);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void preparedEmployees(){
        try {
            statement=con.createStatement();
            String query="Select * From employees where firstname like 'M%'";
            ResultSet rs=statement.executeQuery(query);
            while (rs.next()){
                System.out.println("Firsname:"+rs.getString("firstname"+"lastname:"+
                        rs.getString("lastname")+"Email:"+
                        rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void deleteEmployee(){
        try {
            statement=con.createStatement();
            String query="Delete from employees where id>3";
           int i= statement.executeUpdate(query);
            System.out.println(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  static void updateEmployee() {

        try {
            statement= con.createStatement();
            String query="Update employees Set email ='tk.12@hotmail.com' where id=1";
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addEmployee() {
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

    public static void commitAndRollback(){
        Scanner scanner=new Scanner(System.in);
        try {
            con.setAutoCommit(false);
            String sorgu1= "Delete From employees where id = 3";
            String sorgu2= "Update employees  set email ='wetter@gmaail.com' where id = 1";
            System.out.println("Güncellenmeden önce ");
            getEmployee();
            Statement statement=con.createStatement();
            statement.executeUpdate(sorgu1);
            statement.executeUpdate(sorgu2);
            System.out.println("Islemleriniz kaydedilsin mi? (Yes/No)");
            String cevap=scanner.nextLine();
            if (cevap.equals("Yes")){
                con.commit();
                getEmployee();
                System.out.println("Veri tabani güncellendi...");

            }else {
                con.rollback();
                System.out.println("Veri tabani güncellemesi iptal edildi....");

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void getEmployee() {
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

    public static void   Connect() {

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
       // Connect connect = new Connect();
       // connect.getEmployee();

        //System.out.println("before.....");
       // connect.addEmployee();

       // connect.updateEmployee();
       // connect.deleteEmployee();



        //preparedStatement
        //connect.preparedEmployees();

       // connect.getPrepairedEmployee(3);
        //daha detayli aktarilacak
        commitAndRollback();




    }


}
