
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
   // Ponto 1: Método iniciar conexão
    public Connection conectarBD() {
        Connection conn = null; // Ponto 2
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); // Ponto 3
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123"; 
            conn = DriverManager.getConnection(url); // Ponto 4
        } catch (Exception e) { // Ponto 5
            e.printStackTrace();  // Ponto 6
        }
        return conn; // Ponto 7
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        String sql = "SELECT nome from usuarios where login = ? AND senha = ?"; // Ponto 8

        // Instrução SQL
        try (Connection conn = conectarBD();) { // Ponto 9
            Statement st = conn.createStatement(); // Ponto 10
            ResultSet rs = st.executeQuery(sql);// Ponto 11
            if (rs.next()) { // Ponto 12
                result = true;// Ponto 13
                nome = rs.getString("nome"); // Ponto 14
            }
        } catch (Exception e) { // Ponto 15
            e.printStackTrace(); // Ponto 16
        }
        return result; // Ponto 17
    }
}
