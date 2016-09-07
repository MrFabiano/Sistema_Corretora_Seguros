package dao;

import java.sql.*;  //importa a classe Connection do Java
import javax.swing.JOptionPane;

public class ConexaoDAO {

    private static Connection conexao;  //objeto da classe Connection

    public static Connection getConexao() {
        try { //tenta executar esses comandos..fazer a conexão
            //    JOptionPane.showMessageDialog(null, "AGUARDE CONECTANDO");
            if (conexao == null) {
                //       JOptionPane.showMessageDialog(null, "NAO CONECTA");
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conexao = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "EASYSEG", "EASYSEG");
                //          JOptionPane.showMessageDialog(null, "CONECTADO");

            }
            return conexao;
        } catch (SQLException e) {  //exceções se não der, executa esses comandos
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void desconectar() {
        try {
            conexao.close();
            conexao = null;
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
