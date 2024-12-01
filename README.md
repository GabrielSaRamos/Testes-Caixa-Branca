Erros encontrados:
1) Os catchs não realizam nenhuma função no codigo.
2) Conexoes não fechadas
3) Não é um erro porem pode dar erro no codigo ficar adicionando varias strings SQL ao inves de uma
4) O nome da classe sendo instanciada pra conectar com o banco "com.mysql.Driver.Manager" está errada, deveria ser "com.mysql.cj.jdbc.Driver"

Alterações feitas:

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
   
   4) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();


   Grafo de fluxo:
![Diagrama em branco](https://github.com/user-attachments/assets/2bcfe169-07ed-4167-9227-94053e001a9b)

Complexidade ciclomática (M)

M = E - N + 2P

E (arestas) = 13

N (nós) = 9

P (componentes conectados) = 2

M = 13 - 9 + (2*2)

M = 4 + 4 = 8

Caminhos possíveis 4-1-3-5-6-9 4-1-2-3-5-8-9 4-1-3-5-6-8-9 4-1-3-5-6-7-8-9 4-1-3-5-8-9 4-1-3-5-6-7-9
   

   
