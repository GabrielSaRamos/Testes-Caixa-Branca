
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    public Connection conectarBD() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();  //ALTERAÇÃO: Ausência de Tratamento de Exceções Adequado
        }
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    public boolean verificarUsuario(String login, String senha) {
        String sql = "SELECT nome from usuarios where login = ? AND senha = ?"; //ALTERAÇÃO: Uma string para puxar os dados

        // Instrução SQL
        try (Connection conn = conectarBD();) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            e.printStackTrace(); //ALTERAÇÃO: Ausência de Tratamento de Exceções Adequado
        }
        return result;
    }
}
