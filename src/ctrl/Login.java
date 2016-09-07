package ctrl;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {

    public static void Logar(String LoginDoUsuario, String SenhaDoUsuario) {
        try {
            String SQL = "SELECT usuario.login, usuario.senha "
                    + "FROM usuario "
                    + "WHERE usuario.login = '" + LoginDoUsuario + "'"
                    + "AND usuario.senha = '" + SenhaDoUsuario + "'";
            try {
              //    Class.forName("mysql.jdbc.driver.MySqlDriver");
                 Class.forName("oracle.jdbc.driver.OracleDriver");
               } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "EASYSEG", "EASYSEG");
               
            try {
                Statement st = conexao.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                if (!rs.next()) {
                    System.out.println("Senha errada");
                } else {
                    System.out.println("Entrar no sistema");
                }
            } catch (SQLException e) {
                e.getMessage();
            } catch (Exception e) {
                e.getMessage();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}