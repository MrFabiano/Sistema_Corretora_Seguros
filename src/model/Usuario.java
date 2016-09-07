package model;

import java.util.Date;

public class Usuario {

    private int     Usuarioid            = 0;
    private String  Usuarionome          = "";
    private String  Usuariologin         = "";
    private String  Usuariosenha         = "";
    private int     Usuariogrupoid       = 0;
    private String  Usuariotipo          = "";
    private Date    Usuariodatacriacao   = null;
    private String  Usuariofoto          = "";

    public int getUsuarioid() {
        return Usuarioid;
    }

    public void setUsuarioid(int Usuarioid) {
        this.Usuarioid = Usuarioid;
    }

    public String getUsuarionome() {
        return Usuarionome;
    }

    public void setUsuarionome(String Usuarionome) {
        this.Usuarionome = Usuarionome;
    }

    public String getUsuariologin() {
        return Usuariologin;
    }

    public void setUsuariologin(String Usuariologin) {
        this.Usuariologin = Usuariologin;
    }

    public String getUsuariosenha() {
        return Usuariosenha;
    }

    public void setUsuariosenha(String Usuariosenha) {
        this.Usuariosenha = Usuariosenha;
    }

    public int getUsuariogrupoid() {
        return Usuariogrupoid;
    }

    public void setUsuariogrupoid(int Usuariogrupoid) {
        this.Usuariogrupoid = Usuariogrupoid;
    }

    public String getUsuariotipo() {
        return Usuariotipo;
    }

    public void setUsuariotipo(String Usuariotipo) {
        this.Usuariotipo = Usuariotipo;
    }

    public Date getUsuariodatacriacao() {
        return Usuariodatacriacao;
    }

    public void setUsuariodatacriacao(Date Usuariodatacriacao) {
        this.Usuariodatacriacao = Usuariodatacriacao;
    }

    public String getUsuariofoto() {
        return Usuariofoto;
    }

    public void setUsuariofoto(String Usuariofoto) {
        this.Usuariofoto = Usuariofoto;
    }
    

}
