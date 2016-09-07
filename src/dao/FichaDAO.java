package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Ficha;

public class FichaDAO {

    public static String incluir(Ficha obFicha) {
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) {
            return "Erro na conexão";
        }

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
       
        String sql = "insert into Ficha(idficha, nome, ficha, codigo, relatorio, quantidade, pares, numero, modelo, status) ";
        sql += "values ((select coalesce(max(idficha)+1,1) from ficha),";
        sql += "'" + obFicha.getNome() + "',";
        sql += "'" + obFicha.getFicha() + "',";
        sql += "'" + obFicha.getCodigo() + "',";
        sql += "'" + obFicha.getRelatorio() + "',";
        sql += "'" + obFicha.getQuantidade() + "',";
        sql += "'" + obFicha.getPares() + "',";
        sql += "'" + obFicha.getNumero() + "',";
        sql += "'" + obFicha.getModelo() + "',";
        sql += "'" + obFicha.getStatus() + "',";
        
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            return null; //não teve erro
        } catch (SQLException e) { //erro na sql
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            ConexaoDAO.desconectar();
        }
    }

    public static String alterar(Ficha obFicha) { //recebe o obj p alterar seus atributos
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) //vazia
        {
            return "Erro na conexão";
        }

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        String sql = "update Ficha ";
        sql += "set nome = '" + obFicha.getNome()+ "',";
        sql += "apelido = '" + obFicha.getFicha()+ "',";
        sql += "cpf = '" + obFicha.getCodigo()+ "',";
        sql += "telefone = '" + obFicha.getRelatorio()+ "',";
        sql += "celular = '" + obFicha.getQuantidade()+ "',";
        sql += "celular1 = '" + obFicha.getPares()+ "',";
        sql += "email = '" + obFicha.getNumero()+ "',";
        sql += "email1 = '" + obFicha.getModelo()+ "',";
        sql += "status = '" + obFicha.getStatus()+ "',";
       
        sql += "where idficha = " + obFicha.getIDficha();
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            return null;
        } catch (SQLException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            ConexaoDAO.desconectar();
        }
    }

    public static String excluir(Ficha obFicha) {
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) {
            return "Erro na conexão";
        }

        String sql = "delete from Ficha ";
        sql += "where idficha = " + obFicha.getIDficha();


        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            return null;
        } catch (SQLException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        } finally {
            ConexaoDAO.desconectar();
        }
    }

    public static Ficha buscar(int id) {
        Connection conexao = ConexaoDAO.getConexao();
        Ficha obFicha = null;
        if (conexao == null) {
            return null;
        }

        String sql = "select * from Ficha ";
        sql += "where idficha = " + id;

        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obFicha = new Ficha();
                obFicha.setIDficha(rs.getInt("idficha"));
                obFicha.setNome(rs.getString("nome"));
                obFicha.setFicha(rs.getString("ficha"));
                obFicha.setCodigo(rs.getString("codigo"));
                obFicha.setRelatorio(rs.getString("relatorio"));
                obFicha.setQuantidade(rs.getString("quantidade"));
                obFicha.setPares(rs.getString("pares"));
                obFicha.setNumero(rs.getString("numero"));
                obFicha.setModelo(rs.getString("modelo"));
                obFicha.setStatus(rs.getString("status"));
                
            }
            return obFicha;
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            ConexaoDAO.desconectar();
        }
        return null;

    }

    public static ArrayList<Ficha> buscarTodos() {
        Connection conexao = ConexaoDAO.getConexao();
        ArrayList<Ficha> lstFicha = null;
        Ficha obFicha = null;

        if (conexao == null) {
            return null;
        }

        String sql = "select * from Ficha order by idficha desc";


        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (lstFicha == null) {
                lstFicha = new ArrayList();
            }
            while (rs.next()) {
                obFicha = new Ficha();
                obFicha.setIDficha(rs.getInt("idficha"));
                obFicha.setNome(rs.getString("nome"));
                obFicha.setFicha(rs.getString("ficha"));
                obFicha.setCodigo(rs.getString("codigo"));
                obFicha.setRelatorio(rs.getString("relatorio"));
                obFicha.setQuantidade(rs.getString("quantidade"));
                obFicha.setPares(rs.getString("pares"));
                obFicha.setNumero(rs.getString("numero"));
                obFicha.setModelo(rs.getString("modelo"));
                obFicha.setStatus(rs.getString("status"));
                lstFicha.add(obFicha);
            }

            return lstFicha;

        } catch (SQLException e) {
            return null; //ou pode retornar a msg de erro
        } catch (Exception e) {
            return null;
        } finally {
            ConexaoDAO.desconectar();
        }
     } 
  }