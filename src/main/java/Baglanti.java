import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Baglanti {

    private String kullanici_adi = "root";
    private String paralo = "";
    private String db_ismi = "demo";
    private String host = "localhost";
    private int port = 8888;
    private Connection con = null;
    private String demoUrl="http://localhost:8888/phpMyAdmin/db_structure.php?server=1&db=demo";

    public Baglanti() {
        String url = "jdbc:mysql://" + host + ":" + paralo + "/" + db_ismi;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                con = DriverManager.getConnection(url, kullanici_adi, paralo);
                System.out.println("Baglanti basarili.");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Baglanti baglanti=new Baglanti();


    }
}
