package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import model.Grupo;
import model.Usuario;

public class UsuarioDAO {

    public static String incluir(Usuario obUsuario) {
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) {
            return "Erro na conexão";
        }

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        String sql = "insert into Usuario(usuarioid, usuarionome, usuariologin, usuariosenha, usuariogrupoid, usuariotipo, usuariodatacriacao, usuariofoto) ";
        sql += "values ((select coalesce(max(usuarioid)+1,1) from usuario),";
        sql += "'" + obUsuario.getUsuarionome() + "',";
        sql += "'" + obUsuario.getUsuariologin() + "',";
        sql += "'" + obUsuario.getUsuariosenha() + "',";
        sql += obUsuario.getUsuariogrupoid() + ",";
        sql += "'" + obUsuario.getUsuariotipo() + "',";
        sql += "'" + data.format(obUsuario.getUsuariodatacriacao()) + "',";
        sql += "'" + obUsuario.getUsuariofoto() + "')";
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

    public static String alterar(Usuario obUsuario) { //recebe o obj p alterar seus atributos
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) //vazia
        {
            return "Erro na conexão";
        }

        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        String sql = "update Usuario ";
        sql += "set usuarionome = '" + obUsuario.getUsuarionome() + "',";
        sql += "usuariologin = '" + obUsuario.getUsuariologin() + "',";
        sql += "usuariosenha = '" + obUsuario.getUsuariosenha() + "',";
        sql += "usuariogrupoid = '" + obUsuario.getUsuariogrupoid() + "',";
        sql += "usuariotipo = '" + obUsuario.getUsuariotipo() + "',";
        sql += "usuariodatacriacao = '" + data.format(obUsuario.getUsuariodatacriacao()) + "',";
        sql += "usuariofoto = '" + obUsuario.getUsuariofoto() + "'";
        sql += "where usuarioid = " + obUsuario.getUsuarioid();
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

    public static String excluir(Usuario obUsuario) {
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) {
            return "Erro na conexão";
        }

        String sql = "delete from Usuario ";
        sql += "where usuarioid = " + obUsuario.getUsuarioid();

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

    public static String buscar(Usuario obUsuario) {
        Connection conexao = ConexaoDAO.getConexao();
        if (conexao == null) {
            return "Erro na conexão";
        }

        String sql = "select * from Usuario ";
        sql += "where usuarioid = " + obUsuario.getUsuarioid();

        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (!rs.next()) {
                return "registro nao encontrado";
            } else {
                obUsuario.setUsuarioid(rs.getInt("usuarioid"));
                obUsuario.setUsuarionome(rs.getString("usuarionome"));
                obUsuario.setUsuariologin(rs.getString("usuariologin"));
                obUsuario.setUsuariosenha(rs.getString("usuariosenha"));
                obUsuario.setUsuariogrupoid(rs.getInt("usuariogrupoid"));
                obUsuario.setUsuariotipo(rs.getString("usuariotipo"));
                obUsuario.setUsuariodatacriacao(rs.getDate("usuariodatacriacao"));
                obUsuario.setUsuariofoto(rs.getString("usuariofoto"));
                return null;
            }
        } catch (SQLException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static ArrayList<Usuario> buscarTodos() {
        Connection conexao = ConexaoDAO.getConexao();
        ArrayList<Usuario> lstUsuario = null;
        Usuario obUsuario = null;

        if (conexao == null) {
            return null;
        }

        String sql = "select * from Usuario order by usuarioid desc";


        try {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (lstUsuario == null) {
                lstUsuario = new ArrayList();
            }
            while (rs.next()) {
                obUsuario = new Usuario();
                obUsuario.setUsuarioid(rs.getInt("usuarioid"));
                obUsuario.setUsuarionome(rs.getString("usuarionome"));
                obUsuario.setUsuariologin(rs.getString("usuariologin"));
                obUsuario.setUsuariosenha(rs.getString("usuariosenha"));
                obUsuario.setUsuariogrupoid(rs.getInt("usuariogrupoid"));
                obUsuario.setUsuariotipo(rs.getString("usuariotipo"));
                obUsuario.setUsuariodatacriacao(rs.getDate("usuariodatacriacao"));
                obUsuario.setUsuariofoto(rs.getString("usuariofoto"));
                lstUsuario.add(obUsuario);
            }
            return lstUsuario;
        } catch (SQLException e) {
            return null; //ou pode retornar a msg de erro
        } catch (Exception e) {
            return null;
        }

    }

    public List<Grupo> ConsultaGrupo(String texto) // esse método é utilizado na consulta de grupo em UsuarioView
    {
        Connection conexao = ConexaoDAO.getConexao();
        ArrayList<Grupo> lstGrupo = null;
        Grupo obGrupo = null;

        if (conexao == null) {
            return null;
        }
        String sql = "select * from grupo where grupo.gruponome like '" + texto + "%' order by gruponome";


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
            e.printStackTrace();
            return null; //ou pode retornar a msg de erro
        } catch (Exception e) {
            return null;
        }
    }
}