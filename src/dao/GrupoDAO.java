package dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import model.Grupo;

public class GrupoDAO {

    public static String incluir(Grupo obGrupo) {
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) {
            return "Erro na conexão";
        }

        String sql = "insert into Grupo(grupoid,gruponome) ";
        sql += "values ((select coalesce(max(grupoid)+1,1) from grupo),";
        sql += "'" + obGrupo.getGruponome() + "')";
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            return null; //não teve erro
        } catch (SQLException e) { //erro na sql
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String alterar(Grupo obGrupo) { //recebe o obj p alterar seus atributos
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) //vazia
        {
            return "Erro na conexão";
        }

        String sql = "update Grupo ";
        sql += "set gruponome = '" + obGrupo.getGruponome() + "'";
        sql += "where grupoid = " + obGrupo.getGrupoid();

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            return null;
        } catch (SQLException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String excluir(Grupo obGrupo) {
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) {
            return "Erro na conexão";
        }

        String sql = "delete from Grupo ";
        sql += "where grupoid = " + obGrupo.getGrupoid();

        try {
            Statement st = conexao.createStatement();
            st.executeUpdate(sql);
            return null;
        } catch (SQLException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static String buscar(Grupo obGrupo) {
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) {
            return "Erro na conexão";
        }

        String sql = "select * from Grupo ";
        sql += "where grupoid = " + obGrupo.getGrupoid();

        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                return "registro nao encontrado";
            } else {
                obGrupo.setGrupoid(rs.getInt("grupoid"));
                obGrupo.setGruponome(rs.getString("gruponome"));
                return null;
            }
        } catch (SQLException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static ArrayList<Grupo> buscarTodos() {
        Connection conexao = ConexaoDAO.getConexao();
        ArrayList<Grupo> lstGrupo = null;
        Grupo obGrupo = null;

        if (conexao == null) {
            return null;
        }

        String sql = "select * from Grupo order by grupoid desc";


        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (lstGrupo == null) {
                lstGrupo = new ArrayList();
            }
            while (rs.next()) {
                obGrupo = new Grupo();
                obGrupo.setGrupoid(rs.getInt("grupoid"));
                obGrupo.setGruponome(rs.getString("gruponome"));
                lstGrupo.add(obGrupo);
            }
            return lstGrupo;
        } catch (SQLException e) {
            return null; //ou pode retornar a msg de erro
        } catch (Exception e) {
            return null;
        }

    }
    /* public List BuscaDepartamento(String texto)

     {
     Connection conexao = ConexaoDAO.getConexao();
     ArrayList<Departamento> lstDepartamento = null;
     Departamento obDepartamento = null;

     if (conexao == null)
     return null;
     String sql = "select * from departamento where departamento.departamentonome like '"+texto+"%' order by departamentonome";


     try {
     Statement st = conexao.createStatement();
     ResultSet rs = st.executeQuery(sql);
     if (lstDepartamento == null)
     lstDepartamento = new ArrayList();
     while (rs.next()){
     obDepartamento = new Departamento();
     obDepartamento.setDepartamentoid(rs.getInt("departamentoid"));
     obDepartamento.setDepartamentonome(rs.getString("departamentonome"));

     lstDepartamento.add(obDepartamento);
     }

     return lstDepartamento;
     } catch (SQLException e) {
     e.printStackTrace();
     return null; //ou pode retornar a msg de erro
     } catch (Exception e) {
     return null;
     }

     }
     */
}