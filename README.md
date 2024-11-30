Alterações:

  1) Adicionei em uma unica String o comando SQL
  String sql = "SELECT nome from usuarios where login = ? AND senha = ?"; 
  
  2) Adicionei tratamento de exceções no catch 
  catch (Exception e) {
            e.printStackTrace(); //ALTERAÇÃO: Ausência de Tratamento de Exceções Adequado
        }
  
  3) Fechei conexoes com o banco de dados:
   try (Connection conn = conectarBD();
         PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, login);
        pst.setString(2, senha);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return result;
   